package com.api.etapa2_API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.etapa2_API.dto.request.CursoCriarRequest;
import com.api.etapa2_API.dto.response.CursoDefaultResponse;
import com.api.etapa2_API.dto.response.CursoListarResponse;
import com.api.etapa2_API.service.CursoService;

@RestController
public class CursoController {

	private final CursoService service;
	
	public CursoController(CursoService service) {
		this.service = service;
	}
	
	// Cria um curso;
	@PostMapping("/curso/{idUsuario}")
	public ResponseEntity<CursoDefaultResponse> criarCurso(@PathVariable Long idUsuario, @RequestBody CursoCriarRequest dados){
		CursoDefaultResponse resposta = service.criarCurso(idUsuario, dados);
		if(resposta == null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(resposta);
	}
	
	// Retorna cursos existentes;
	@GetMapping("/curso")
	public ResponseEntity<List<CursoListarResponse>> listarCursos(){
		return ResponseEntity.ok(service.listarCursos());
	}
	
	// Retorna curso por ID;
	@GetMapping("/curso/{id}")
	public ResponseEntity<CursoListarResponse> listarCursoPorId(@PathVariable Long id){
		CursoListarResponse curso = service.listarCursoPorId(id);
		if(curso == null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(curso);
	}
}

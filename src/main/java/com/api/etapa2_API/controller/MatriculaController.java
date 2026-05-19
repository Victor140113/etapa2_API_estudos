package com.api.etapa2_API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.etapa2_API.dto.request.MatriculaAlunoRequest;
import com.api.etapa2_API.dto.response.MatriculaCursoResponse;
import com.api.etapa2_API.dto.response.MatriculaDefaultResponse;
import com.api.etapa2_API.dto.response.MatriculaUsuarioResponse;
import com.api.etapa2_API.service.MatriculaService;

@RestController
public class MatriculaController {

	private final MatriculaService service;
	
	public MatriculaController(MatriculaService service) {
		this.service = service;
	}
	
	// Matricula um aluno;
	@PostMapping("/matricula")
	public ResponseEntity<MatriculaDefaultResponse> matricularAluno(@RequestBody MatriculaAlunoRequest dados){
		
		MatriculaDefaultResponse matricula = service.matricularAluno(dados);
		
		if(matricula == null) return ResponseEntity.status(409).build();
		
		return ResponseEntity.ok(matricula);
	}
	
	// Pegar todas as matrículas pelo ID do aluno;
	@GetMapping("/matricula/usuario/{id}")
	public ResponseEntity<List<MatriculaUsuarioResponse>> listarMatriculasUsuario(@PathVariable Long id){
		
		List<MatriculaUsuarioResponse> matricula = service.listarMatriculasUsuario(id);
		if(matricula == null || matricula.size() == 0) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(matricula);
	}
	
	// Pegar todas as matrículas de um curso por ID;
	@GetMapping("/matricula/curso/{id}")
	public ResponseEntity<List<MatriculaCursoResponse>> listarMatriculasCurso(@PathVariable Long id){
		
		List<MatriculaCursoResponse> matriculas = service.listarMatriculasCurso(id);
		if(matriculas == null || matriculas.size() == 0 ) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(matriculas);
		
	}
	
}

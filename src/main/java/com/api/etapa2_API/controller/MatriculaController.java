package com.api.etapa2_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.etapa2_API.dto.request.MatriculaAlunoRequest;
import com.api.etapa2_API.dto.response.MatriculaDefaultResponse;
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
	
}

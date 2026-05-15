package com.api.etapa2_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.etapa2_API.dto.request.CadastroRequest;
import com.api.etapa2_API.dto.response.CadastroResponse;
import com.api.etapa2_API.service.UsuarioService;

@RestController
public class UsuarioController {

	public final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	// Cadastro de Usuário;
	@PostMapping("/usuario")
	public ResponseEntity<CadastroResponse> cadastrarUsuario(@RequestBody CadastroRequest dados){
		
		CadastroResponse cadastro = service.cadastrarUsuario(dados);
		
		if(cadastro == null) return ResponseEntity.status(409).build();
		
		return ResponseEntity.ok(cadastro);
	}
	
}

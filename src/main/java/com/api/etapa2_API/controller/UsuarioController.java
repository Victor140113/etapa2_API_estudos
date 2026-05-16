package com.api.etapa2_API.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.etapa2_API.dto.request.UsuarioCadastroRequest;
import com.api.etapa2_API.dto.request.UsuarioLoginRequest;
import com.api.etapa2_API.dto.response.UsuarioCadastroResponse;
import com.api.etapa2_API.dto.response.UsuarioLoginResponse;
import com.api.etapa2_API.service.UsuarioService;

@RestController
public class UsuarioController {

	public final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	// Cadastro de Usuário;
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioCadastroResponse> cadastrarUsuario(@RequestBody UsuarioCadastroRequest dados){
		
		UsuarioCadastroResponse cadastroResult = service.cadastrarUsuario(dados);
		
		if(cadastroResult == null) return ResponseEntity.status(409).build();
		
		return ResponseEntity.ok(cadastroResult);
	}
	
	// Login de Usuário;
	@PostMapping("/usuario/login")
	public ResponseEntity<UsuarioLoginResponse> login(@RequestBody UsuarioLoginRequest dados){
		UsuarioLoginResponse loginResult = service.login(dados);
		
		if(loginResult == null) return ResponseEntity.status(400).build();
		
		return ResponseEntity.ok(loginResult);
	}
	
}

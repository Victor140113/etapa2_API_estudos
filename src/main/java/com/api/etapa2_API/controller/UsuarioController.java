package com.api.etapa2_API.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.etapa2_API.dto.request.UsuarioAtualizarRequest;
import com.api.etapa2_API.dto.request.UsuarioCadastroRequest;
import com.api.etapa2_API.dto.request.UsuarioLoginRequest;
import com.api.etapa2_API.dto.response.UsuarioDefaultResponse;
import com.api.etapa2_API.dto.response.UsuarioListarResponse;
import com.api.etapa2_API.service.UsuarioService;

@RestController
public class UsuarioController {

	public final UsuarioService service;
	
	public UsuarioController(UsuarioService service) {
		this.service = service;
	}
	
	// Cadastro de Usuário;
	@PostMapping("/usuario")
	public ResponseEntity<UsuarioDefaultResponse> cadastrarUsuario(@RequestBody UsuarioCadastroRequest dados){
		
		UsuarioDefaultResponse cadastroResult = service.cadastrarUsuario(dados);
		
		if(cadastroResult == null) return ResponseEntity.status(409).build();
		
		return ResponseEntity.ok(cadastroResult);
	}
	
	// Login de Usuário;
	@PostMapping("/usuario/login")
	public ResponseEntity<UsuarioDefaultResponse> login(@RequestBody UsuarioLoginRequest dados){
		UsuarioDefaultResponse loginResult = service.login(dados);
		
		if(loginResult == null) return ResponseEntity.status(400).build();
		
		return ResponseEntity.ok(loginResult);
	}
	
	// Retornar os nomes dos usuários existentes;
	@GetMapping("/usuario")
	public ResponseEntity<List<UsuarioListarResponse>> listarUsuarios(){
		return ResponseEntity.ok(service.listarUsuarios());
	}
	
	// Retornar usuario por id;
	@GetMapping("/usuario/{id}")
	public ResponseEntity<UsuarioListarResponse> listarUsuarioPorId(@PathVariable Long id){
		UsuarioListarResponse usuario = service.listarUsuarioPorId(id);
		if(usuario == null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(usuario);
		
	}
	
	// Atualizar nome, email e senha de usuário por ID;
	@PutMapping("/usuario/{id}")
	public ResponseEntity<UsuarioDefaultResponse> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioAtualizarRequest dados){
		UsuarioDefaultResponse usuario = service.atualizarUsuario(id, dados);
		if(usuario == null) return ResponseEntity.status(404).build();
		
		return ResponseEntity.ok(usuario);
	}
	
}

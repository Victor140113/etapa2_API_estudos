package com.api.etapa2_API.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.etapa2_API.dto.request.UsuarioCadastroRequest;
import com.api.etapa2_API.dto.request.UsuarioLoginRequest;
import com.api.etapa2_API.dto.response.UsuarioCadastroResponse;
import com.api.etapa2_API.dto.response.UsuarioListarResponse;
import com.api.etapa2_API.dto.response.UsuarioLoginResponse;
import com.api.etapa2_API.entity.UsuarioEntity;
import com.api.etapa2_API.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository database;
	
	public UsuarioService(UsuarioRepository database) {
		this.database = database;
	}
	
	//================Métodos Externos====================
	
	// Validação de cadastro;
	public UsuarioCadastroResponse cadastrarUsuario(UsuarioCadastroRequest dados) {
		if(database.existsByEmail(dados.getEmail())) {
			return null;
		}
		UsuarioEntity salvarDados = new UsuarioEntity(dados.getNome(), dados.getEmail(), dados.getSenha(), dados.getTipo());
		database.save(salvarDados);
		return new UsuarioCadastroResponse("Sua conta foi salva!");
	}
	
	// Validação de login;
	public UsuarioLoginResponse login(UsuarioLoginRequest dados) {
		UsuarioEntity usuario = database.findByEmail(dados.getEmail());
		
		if(usuario == null) return null;
		
		if(usuario.getEmail().equals(dados.getEmail()) == false || usuario.getSenha().equals(dados.getSenha()) == false) {
			return null;
		} else {
			return new UsuarioLoginResponse("Login Efetuado com Sucesso!");
		}
	}
	
	// Listar Usuários;
	public List<UsuarioListarResponse> listarUsuarios(){
		return database.findAll().stream().map(usuario -> new UsuarioListarResponse(usuario.getNome(), usuario.getEmail())).toList();
	}
	
	//====================================================
	
	
	//===================Métodos Internos=================
	
	
	
	//====================================================
}

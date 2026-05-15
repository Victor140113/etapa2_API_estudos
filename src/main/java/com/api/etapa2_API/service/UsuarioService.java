package com.api.etapa2_API.service;

import org.springframework.stereotype.Service;

import com.api.etapa2_API.controller.UsuarioRepository;
import com.api.etapa2_API.dto.request.CadastroRequest;
import com.api.etapa2_API.dto.response.CadastroResponse;
import com.api.etapa2_API.entity.UsuarioEntity;

@Service
public class UsuarioService {

	private final UsuarioRepository database;
	
	public UsuarioService(UsuarioRepository database) {
		this.database = database;
	}
	
	//================Métodos Externos====================
	
	public CadastroResponse cadastrarUsuario(CadastroRequest dados) {
		if(database.existsByEmail(dados.getEmail())) {
			return null;
		}
		UsuarioEntity salvarDados = new UsuarioEntity(dados.getNome(), dados.getEmail(), dados.getSenha(), dados.getTipo());
		database.save(salvarDados);
		return new CadastroResponse("Sua conta foi salva!");
	}
	
	//====================================================
	
	
	//===================Métodos Internos=================
	
	
	
	//====================================================
}

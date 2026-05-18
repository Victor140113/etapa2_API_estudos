package com.api.etapa2_API.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.etapa2_API.dto.request.UsuarioAtualizarRequest;
import com.api.etapa2_API.dto.request.UsuarioCadastroRequest;
import com.api.etapa2_API.dto.request.UsuarioLoginRequest;
import com.api.etapa2_API.dto.response.UsuarioDefaultResponse;
import com.api.etapa2_API.dto.response.UsuarioListarResponse;
import com.api.etapa2_API.entity.CursoEntity;
import com.api.etapa2_API.entity.UsuarioEntity;
import com.api.etapa2_API.repository.CursoRepository;
import com.api.etapa2_API.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private final UsuarioRepository database;
	private final CursoRepository cursoRepository;
	
	public UsuarioService(UsuarioRepository database, CursoRepository cursoRepository) {
		this.database = database;
		this.cursoRepository = cursoRepository;
	}
	
	//================Métodos Externos====================
	
	// Validação de cadastro;
	public UsuarioDefaultResponse cadastrarUsuario(UsuarioCadastroRequest dados) {
		if(database.existsByEmail(dados.getEmail())) {
			return null;
		}
		UsuarioEntity salvarDados = new UsuarioEntity(dados.getNome(), dados.getEmail(), dados.getSenha(), dados.getTipo());
		database.save(salvarDados);
		return new UsuarioDefaultResponse("Sua conta foi salva!");
	}
	
	// Validação de login;
	public UsuarioDefaultResponse login(UsuarioLoginRequest dados) {
		UsuarioEntity usuario = database.findByEmail(dados.getEmail());
		
		if(usuario == null) return null;
		
		if(usuario.getEmail().equals(dados.getEmail()) == false || usuario.getSenha().equals(dados.getSenha()) == false) {
			return null;
		} else {
			return new UsuarioDefaultResponse("Login Efetuado com Sucesso!");
		}
	}
	
	// Listar Usuários;
	public List<UsuarioListarResponse> listarUsuarios(){
		return database.findAll().stream().map(usuario -> new UsuarioListarResponse(usuario.getNome(), usuario.getEmail())).toList();
	}
	
	// Listar Usuário por ID;
	public UsuarioListarResponse listarUsuarioPorId(Long id) {
		UsuarioEntity usuario = database.findById(id).orElse(null);
		if(usuario == null) return null;
		
		return new UsuarioListarResponse(usuario.getNome(), usuario.getEmail());
	}
	
	// Atualizar usuário;
	public UsuarioDefaultResponse atualizarUsuario(Long id, UsuarioAtualizarRequest dados) {
		UsuarioEntity usuario = database.findById(id).orElse(null);
		if(usuario == null) return null;
		
		usuario.setNome(dados.getNome());
		usuario.setEmail(dados.getEmail());
		usuario.setSenha(dados.getSenha());
		
		database.save(usuario);
		return new UsuarioDefaultResponse("Suas credenciais novas foram salvas!");
		
	}
	
	// Deletar usuário;
	public UsuarioDefaultResponse deletarUsuario(Long id) {
		
		UsuarioEntity usuario = database.findById(id).orElse(null);
		if(usuario == null) return null;
				
		for(CursoEntity curso : usuario.getListaDeCursos()) {
			curso.setCursoDono(null);
			cursoRepository.save(curso);
		}
		
		database.delete(usuario);
		
		return new UsuarioDefaultResponse("Sua conta foi deletada com sucesso!");
	}
	
	//====================================================
	
	
	//===================Métodos Internos=================
	
	// Retorna usuário;
	public UsuarioEntity getUsuarioPorId(Long id) {
		
		UsuarioEntity usuario = database.findById(id).orElse(null);
		if(usuario == null) return null;
		
		return usuario;
		
	}
	
	//====================================================
}

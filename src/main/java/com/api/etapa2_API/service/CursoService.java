package com.api.etapa2_API.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.etapa2_API.dto.request.CursoCriarRequest;
import com.api.etapa2_API.dto.response.CursoDefaultResponse;
import com.api.etapa2_API.dto.response.CursoListarResponse;
import com.api.etapa2_API.entity.CursoEntity;
import com.api.etapa2_API.entity.UsuarioEntity;
import com.api.etapa2_API.enums.UsuarioTipo;
import com.api.etapa2_API.repository.CursoRepository;

@Service
public class CursoService {

	private final CursoRepository database;
	private final UsuarioService usuarioService;
	
	public CursoService(CursoRepository database, UsuarioService usuarioService) {
		this.database = database;
		this.usuarioService = usuarioService;
	}
	
	
	//========================Métodos Externos==============================
	
	
	
	// Valida a criação do Curso;
	public CursoDefaultResponse criarCurso(Long idUsuario, CursoCriarRequest dados) {
		
		UsuarioEntity usuario = usuarioService.getUsuarioPorId(idUsuario);
		if(usuario == null) return null;
		
		if(usuario.getTipo() != UsuarioTipo.PROFESSOR) return null;
		
		CursoEntity curso = new CursoEntity();
		
		curso.setTitulo(dados.getTitulo());
		curso.setDescricao(dados.getDescricao());
		curso.setDificuldade(dados.getDificuldade());
		curso.setCursoDono(usuario);
		
		usuario.getListaDeCursos().add(curso);
		
		database.save(curso);
		return new CursoDefaultResponse("Curso criado com sucesso!");
	}
	
	// Retorna cursos existentes;
	public List<CursoListarResponse> listarCursos(){
		
		return database.findAll().stream().map(curso -> new CursoListarResponse(curso.getCursoDono().getNome(), curso.getTitulo(), curso.getDescricao(), curso.getDificuldade())).toList();
	}
	
	// Retorna curso por ID;
	public CursoListarResponse listarCursoPorId(Long id) {
		
		CursoEntity curso = database.findById(id).orElse(null);
		if(curso == null) return null;
		String nomeCriador = curso.getCursoDono() == null ? "Desconhecido" : curso.getCursoDono().getNome();
		
		return new CursoListarResponse(nomeCriador, curso.getTitulo(), curso.getDescricao(), curso.getDificuldade());
		
	}
	
	//============================Métodos Internos=========================
	
	
	
	
	
	//======================================================================
	
}

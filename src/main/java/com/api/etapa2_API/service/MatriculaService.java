package com.api.etapa2_API.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.etapa2_API.dto.request.MatriculaAlunoRequest;
import com.api.etapa2_API.dto.request.MatriculaAtualizarRequest;
import com.api.etapa2_API.dto.response.MatriculaCursoResponse;
import com.api.etapa2_API.dto.response.MatriculaDefaultResponse;
import com.api.etapa2_API.dto.response.MatriculaUsuarioResponse;
import com.api.etapa2_API.entity.CursoEntity;
import com.api.etapa2_API.entity.MatriculaEntity;
import com.api.etapa2_API.entity.UsuarioEntity;
import com.api.etapa2_API.enums.MatriculaStatus;
import com.api.etapa2_API.enums.UsuarioTipo;
import com.api.etapa2_API.repository.MatriculaRepository;

@Service
public class MatriculaService {

	private final MatriculaRepository database;
	private final UsuarioService usuarioService;
	private final CursoService cursoService;
	
	public MatriculaService(MatriculaRepository database, UsuarioService usuarioService, CursoService cursoService) {
		this.database = database;
		this.usuarioService = usuarioService;
		this.cursoService = cursoService;
	}
	
	//===============================Métodos Externos===============================
	
	
	// Valida matrícula de Aluno;
	public MatriculaDefaultResponse matricularAluno(MatriculaAlunoRequest dados) {
		
		UsuarioEntity aluno = usuarioService.getUsuarioPorId(dados.getIdAluno());
		if(aluno == null) return null;
		if(aluno.getTipo() != UsuarioTipo.ALUNO) return null;
		
		CursoEntity curso = cursoService.getCursoPorId(dados.getIdCurso());
		if(curso == null) return null;
		
		if(database.existsByUsuarioAndCurso(aluno, curso)) return null;
		
		
		database.save(new MatriculaEntity(1, MatriculaStatus.CURSANDO, aluno, curso));
		
		return new MatriculaDefaultResponse("Matrícula realizada!");
		
	}
	
	// Retorna dados das matrículas de um usuário por ID;
	public List<MatriculaUsuarioResponse> listarMatriculasUsuario(Long id){
		
		UsuarioEntity usuario = usuarioService.getUsuarioPorId(id);
		if(usuario == null) return null;
		
		return database.findAllByUsuario(usuario).stream().map(matricula -> new MatriculaUsuarioResponse(matricula.getCurso().getTitulo(), matricula.getDataMatricula(), matricula.getProgresso(), matricula.getStatus())).toList();
	}
	
	// Retorna alunos matriculado em um curso por ID de curso;
	public List<MatriculaCursoResponse> listarMatriculasCurso(Long id){
		
		CursoEntity curso = cursoService.getCursoPorId(id);
		if(curso == null) return null;
		
		return database.findAllByCurso(curso).stream().map(matricula -> new MatriculaCursoResponse(matricula.getUsuario().getNome(), matricula.getDataMatricula())).toList();
	}
	
	// Atualizar progresso e status de uma matricula;
	public MatriculaDefaultResponse atualizarMatricula(Long id, MatriculaAtualizarRequest dados) {
		
		MatriculaEntity matricula = database.findById(id).orElse(null);
		if(matricula == null) return null;
		
		matricula.setProgresso(dados.getProgresso());
		matricula.setStatus(dados.getStatus());
		
		database.save(matricula);
		return new MatriculaDefaultResponse("Matrícula atualizada!");
	}
	
	// Deletar matrícula;
	public MatriculaDefaultResponse deletarMatricula(Long id) {
		
		if(!database.existsById(id)) return null;
		
		database.deleteById(id);
		return new MatriculaDefaultResponse("Você saiu do curso!");
	}
	
	//==============================================================================
}

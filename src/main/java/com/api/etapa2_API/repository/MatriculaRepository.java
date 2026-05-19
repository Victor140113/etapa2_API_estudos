package com.api.etapa2_API.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.etapa2_API.entity.CursoEntity;
import com.api.etapa2_API.entity.MatriculaEntity;
import com.api.etapa2_API.entity.UsuarioEntity;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long>{

	// Verifica se matrícula existe com determinado usuário;
	public boolean existsByUsuario(UsuarioEntity usuario);
	
	// Verifica se matrícula existe com determinado curso;
	public boolean existsByCurso(CursoEntity curso);
	
	// Pega lista com todos os cursos de um determinado usuário;
	public List<MatriculaEntity> findAllByUsuario(UsuarioEntity usuario);
	
	// Verifica se um usuário está matriculado em um curso;
	public boolean existsByUsuarioAndCurso(UsuarioEntity usuario, CursoEntity curso);
}

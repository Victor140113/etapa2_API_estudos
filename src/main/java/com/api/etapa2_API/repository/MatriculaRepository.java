package com.api.etapa2_API.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.etapa2_API.entity.CursoEntity;
import com.api.etapa2_API.entity.MatriculaEntity;
import com.api.etapa2_API.entity.UsuarioEntity;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Long>{
	
	// Verifica se um usuário está matriculado em um curso;
	public boolean existsByUsuarioAndCurso(UsuarioEntity usuario, CursoEntity curso);
	
	// Retorna todas as matriculas de um usuário;
	public List<MatriculaEntity> findAllByUsuario(UsuarioEntity usuario);
}
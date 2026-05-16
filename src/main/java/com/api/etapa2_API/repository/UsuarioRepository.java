package com.api.etapa2_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.etapa2_API.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

	// Retorna verdadeiro caso o email enviado exista.
	public boolean existsByEmail(String email);
	
	// Busca por email;
	public UsuarioEntity findByEmail(String email);
}

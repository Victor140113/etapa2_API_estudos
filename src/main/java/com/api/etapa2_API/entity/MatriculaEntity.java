package com.api.etapa2_API.entity;

import java.time.LocalDate;

import com.api.etapa2_API.enums.MatriculaStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class MatriculaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate dataMatricula;
	private int progresso;
	
	@Enumerated(EnumType.STRING)
	private MatriculaStatus status;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UsuarioEntity usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private CursoEntity curso;
	
	public MatriculaEntity() {
		
	}
	
	public MatriculaEntity(LocalDate dataMatricula, int progresso, MatriculaStatus status) {
		this.dataMatricula = dataMatricula;
		this.progresso = progresso;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public int getProgresso() {
		return progresso;
	}

	public void setProgresso(int progresso) {
		this.progresso = progresso;
	}

	public MatriculaStatus getStatus() {
		return status;
	}

	public void setStatus(MatriculaStatus status) {
		this.status = status;
	}
	
}

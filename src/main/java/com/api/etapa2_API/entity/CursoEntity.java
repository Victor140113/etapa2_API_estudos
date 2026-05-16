package com.api.etapa2_API.entity;

import java.util.ArrayList;
import java.util.List;

import com.api.etapa2_API.enums.CursoDificuldade;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CursoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String titulo;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private CursoDificuldade dificuldade;
	
	@OneToMany(mappedBy = "curso")
	private List<MatriculaEntity> matricula = new ArrayList<>();
	
	public CursoEntity() {
		
	}
	
	public CursoEntity(String titulo, String descricao, CursoDificuldade dificuldade) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dificuldade = dificuldade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public CursoDificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(CursoDificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	public List<MatriculaEntity> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<MatriculaEntity> matricula) {
		this.matricula = matricula;
	}

	
	
}

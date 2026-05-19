package com.api.etapa2_API.entity;

import java.util.ArrayList;
import java.util.List;

import com.api.etapa2_API.enums.UsuarioTipo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String email;
	private String senha;
	
	@Enumerated(EnumType.STRING)
	private UsuarioTipo tipo;
	
	@OneToMany(mappedBy = "cursoDono", fetch = FetchType.LAZY)
	private List<CursoEntity> listaDeCursos = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE)
	private List<MatriculaEntity> matricula = new ArrayList<>();
	
	public UsuarioEntity() {
		
	}
	
	public UsuarioEntity(String nome, String email, String senha, UsuarioTipo tipo) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioTipo getTipo() {
		return tipo;
	}

	public void setTipo(UsuarioTipo tipo) {
		this.tipo = tipo;
	}

	public List<MatriculaEntity> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<MatriculaEntity> matricula) {
		this.matricula = matricula;
	}

	public List<CursoEntity> getListaDeCursos() {
		return listaDeCursos;
	}

	public void setListaDeCursos(List<CursoEntity> listaDeCursos) {
		this.listaDeCursos = listaDeCursos;
	}

	
	
}

package com.api.etapa2_API.dto.response;

import com.api.etapa2_API.enums.CursoDificuldade;

public class CursoListarResponse {

	private String criador;
	private String titulo;
	private String descricao;
	private CursoDificuldade dificuldade;
	
	public CursoListarResponse(String criador, String titulo, String descricao, CursoDificuldade dificuldade) {
		this.criador = criador;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dificuldade = dificuldade;
	}

	public String getCriador() {
		return criador;
	}

	public void setCriador(String criador) {
		this.criador = criador;
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
}

package com.api.etapa2_API.dto.request;

import com.api.etapa2_API.enums.CursoDificuldade;

public class CursoAtualizarRequest {

	private String titulo;
	private String descricao;
	private CursoDificuldade dificuldade;
	
	public CursoAtualizarRequest() {
		
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

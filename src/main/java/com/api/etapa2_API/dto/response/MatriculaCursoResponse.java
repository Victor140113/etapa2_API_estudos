package com.api.etapa2_API.dto.response;

import java.time.LocalDate;

public class MatriculaCursoResponse {

	private String nomeAluno;
	private LocalDate dataMatricula;
	
	public MatriculaCursoResponse(String nomeAluno, LocalDate dataMatricula) {
		this.nomeAluno = nomeAluno;
		this.dataMatricula = dataMatricula;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public LocalDate getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(LocalDate dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
}

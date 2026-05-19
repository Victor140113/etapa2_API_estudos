package com.api.etapa2_API.dto.response;

import java.time.LocalDate;

import com.api.etapa2_API.enums.MatriculaStatus;

public class MatriculaUsuarioResponse {

	private String tituloCurso;
	private LocalDate dataMatricula;
	private int progresso;
	private MatriculaStatus status;
	
	public MatriculaUsuarioResponse(String tituloCurso, LocalDate dataMatricula, int progresso, MatriculaStatus status) {
		this.tituloCurso = tituloCurso;
		this.dataMatricula = dataMatricula;
		this.progresso = progresso;
		this.status = status;
	}
	
	public String getTituloCurso() {
		return tituloCurso;
	}

	public void setTituloCurso(String tituloCurso) {
		this.tituloCurso = tituloCurso;
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

package com.api.etapa2_API.dto.request;

public class MatriculaAlunoRequest {

	private Long idAluno;
	private Long idCurso;

	public Long getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Long idCurso) {
		this.idCurso = idCurso;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	
	
}

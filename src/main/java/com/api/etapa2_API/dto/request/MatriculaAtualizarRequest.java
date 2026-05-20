package com.api.etapa2_API.dto.request;

import com.api.etapa2_API.enums.MatriculaStatus;

public class MatriculaAtualizarRequest {

	private int progresso;
	private MatriculaStatus status;
	
	public MatriculaAtualizarRequest(int progresso, MatriculaStatus status) {
		this.progresso = progresso;
		this.status = status;
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

package com.api.etapa2_API.dto.response;

public class MatriculaDefaultResponse {

	private String mensagem;
	
	public MatriculaDefaultResponse(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

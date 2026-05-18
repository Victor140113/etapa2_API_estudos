package com.api.etapa2_API.dto.response;

public class CursoDefaultResponse {

	private String mensagem;
	
	public CursoDefaultResponse(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

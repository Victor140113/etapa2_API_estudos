package com.api.etapa2_API.dto.response;

public class UsuarioDefaultResponse {

	private String mensagem;
	
	public UsuarioDefaultResponse(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}

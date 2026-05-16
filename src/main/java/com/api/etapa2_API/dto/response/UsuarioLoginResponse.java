package com.api.etapa2_API.dto.response;

public class UsuarioLoginResponse {

	private String mensagem;
	
	public UsuarioLoginResponse(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}

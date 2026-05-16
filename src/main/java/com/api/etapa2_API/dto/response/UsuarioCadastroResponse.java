package com.api.etapa2_API.dto.response;

public class UsuarioCadastroResponse {

	private String mensagem;
	
	public UsuarioCadastroResponse(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}

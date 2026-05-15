package com.api.etapa2_API.dto.response;

public class CadastroResponse {

	private String mensagem;
	
	public CadastroResponse(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
}

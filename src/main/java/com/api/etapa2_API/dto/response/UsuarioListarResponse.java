package com.api.etapa2_API.dto.response;

public class UsuarioListarResponse {

	private String nome;
	private String email;
	
	public UsuarioListarResponse(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

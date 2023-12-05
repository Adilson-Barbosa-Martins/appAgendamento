package br.edu.infnet.appAgendamento.model.domain;



public class Usuario {
	protected int id;
	protected String nome;
	protected String email;
	protected String senha;

	public String toString() {
		return String.format("nome (%s) - email (%s) - senha (%s)", nome, email, senha);
	}

	public int getid() {
		return id;
	}

	public void setid(int idUsuario) {
		this.id = idUsuario;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}


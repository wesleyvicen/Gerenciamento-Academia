package br.com.novaroma.entidades;

import java.io.Serializable;

public class Pessoa implements Serializable{

	private static final long serialVersionUID = 2130779371185722554L;
	private String nome, cpf, sexo;

	public Pessoa(String nome, String cpf, String sexo) {
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
}

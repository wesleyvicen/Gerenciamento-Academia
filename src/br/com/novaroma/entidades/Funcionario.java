package br.com.novaroma.entidades;

import java.io.Serializable;

public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = 8052238141880785208L;
	private String cargo;
	private double salario;
	private int idade;
	private boolean salarioPag;

	public Funcionario(String nome, String cpf, String sexo, String cargo, double salario, int idade,
			boolean salarioPag) {
		super(nome, cpf, sexo);
		this.cargo = cargo;
		this.salario = salario;
		this.idade = idade;
		this.salarioPag = salarioPag;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public boolean getSalarioPag() {
		return salarioPag;
	}

	public String pagSalario() {
		if (this.salarioPag == true) {
			return "Pago";
		}
		return "Não pago";

	}

	public void setSalarioPag(boolean salarioPag) {
		this.salarioPag = salarioPag;
	}

	public String toString() {
		return "Funcionario [nome: " + super.getNome().toUpperCase() + " | CPF: " + super.getCpf() + " | sexo: " + super.getSexo().toUpperCase()
				+ " | cargo: " + cargo + " | salario: " + salario + " | idade: " + idade + " | salarioPag: "
				+ pagSalario() + "] \n";
	}

}

package br.com.novaroma.apresentacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.dados.DAO;
import br.com.novaroma.entidades.Cliente;
import br.com.novaroma.entidades.Funcionario;
import br.com.novaroma.excecoes.ExcecaoBancoVazio;
import br.com.novaroma.interfaces.IApresentacao;
import br.com.novaroma.util.Util;

public class FuncionarioApresentacao<T> implements IApresentacao<T> {
	private static Scanner scanner = new Scanner(System.in);

	public T preencher() {
		System.out.println("================= Digite seu nome: =================");
		String nome = scanner.nextLine();
		System.out.println("================= Digite seu CPF: =================");
		String cpf = scanner.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scanner.next();
		}
		System.out.println("================= Digite sexo: ==================");
		String sexo = scanner.next();
		System.out.println("================= Digite Cargo: =================");
		String cargo = scanner.next();
		System.out.println("================= Digite seu Salario:============");
		double salario = scanner.nextDouble();
		System.out.println("================= Digite sua idade: ==============");
		int idade = scanner.nextInt();
		System.out.println("Funcionario recebeu o Pagamento? se SIM, digite SIM");
		String pagMensal = scanner.next();
		if (pagMensal.equalsIgnoreCase("sim")) {
			return (T) new Funcionario(nome, cpf, sexo, cargo, salario, idade, true);
		}
		return (T) new Funcionario(nome, cpf, sexo, cargo, salario, idade, false);

	}

	public T remover() {
		System.out.println("================= Digite seu cpf: =================");
		String cpf = scanner.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scanner.next();
		}

		return (T) new Funcionario(null, cpf, null, null, 0, 0, false);
	}

	public T consultar() {
		System.out.println("================= Digite seu cpf: =================");
		String cpf = scanner.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scanner.next();
		}
		return (T) new Funcionario(null, cpf, null, null, 0, 0, false);
	}

	public ArrayList<T> exibirFuncionario(Funcionario funcionario) throws ClassNotFoundException, IOException, ExcecaoBancoVazio {
		DAO<T> f = new DAO<>();
		return f.exibir((T) funcionario);
	}

	public ArrayList<T> exibirCliente(Cliente f6) throws ClassNotFoundException, IOException, ExcecaoBancoVazio {
		DAO<T> f = new DAO<>();
		return f.exibir((T) f6);
	}

	public T atualizar() {
		System.out.println("================= Digite cpf do funcionario que deseja atualizar : ==================");
		String cpf = scanner.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scanner.next();
		}
		System.out.println("================= Atualizando: ==================");

		System.out.println("================= Digite nome: ==================");
		String nome = scanner.next();
		System.out.println("================= Digite sexo: ==================");
		String sexo = scanner.next();
		System.out.println("================= Digite Cargo: =================");
		String cargo = scanner.next();
		System.out.println("================= Digite seu Salario:============");
		double salario = scanner.nextDouble();
		System.out.println("================= Digite sua idade: ==============");
		int idade = scanner.nextInt();
		return (T) new Funcionario(nome, cpf, sexo, cargo, salario, idade, false);

	}

}

package br.com.novaroma.apresentacao;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import br.com.novaroma.dados.DAO;
import br.com.novaroma.entidades.Cliente;
import br.com.novaroma.entidades.Planos;
import br.com.novaroma.excecoes.ExcecaoBancoVazio;
import br.com.novaroma.interfaces.IApresentacao;
import br.com.novaroma.negocio.PlanosNegocio;
import br.com.novaroma.util.Util;

public class ClienteAprensentacao<T> extends Telas implements IApresentacao<T> {
	private static Scanner scan = new Scanner(System.in);
	static PlanosNegocio planosNegocio = new PlanosNegocio();
	static Planos planos;
	static DecimalFormat df = new DecimalFormat("#,##0.00");

	public T preencher() {
		System.out.println("================= Digite seu nome: =================");
		String nome = scan.next();
		System.out.println("================= Digite seu CPF: =================");
		String cpf = scan.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scan.next();
		}
		System.out.println("================= Digite seu Sexo: =================");
		String sexo = scan.next();
		System.out.println("================= Digite peso: ==================");
		double peso = scan.nextDouble();
		System.out.println("================= Digite altura: ================");
		double altura = scan.nextDouble();
		System.out.println("================= Digite idade: =================");
		int idade = scan.nextInt();
		System.out.println("Cliente fez o Pagamento? se SIM, digite SIM");
		String pagMensal = scan.next();
		if (pagMensal.equalsIgnoreCase("sim")) {
			return (T) new Cliente(nome, cpf, sexo, peso, altura, idade, true);
		}
		return (T) new Cliente(nome, cpf, sexo, peso, altura, idade, false);

	}

	public T remover() {
		System.out.println("================= Digite seu cpf: =================");
		String cpf = scan.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scan.next();
		}
		// Fazer verificação se o Cliente no CPF existe.

		return (T) new Cliente(null, cpf, null, 0, 0, 0, false);
	}

	public T consultar() {
		System.out.println("================= Digite seu cpf: =================");

		String cpf = scan.next();

		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scan.next();

		}
		return (T) new Cliente(null, cpf, null, 0, 0, 0, false);

	}

	public ArrayList<T> exibir(T t) throws ClassNotFoundException, IOException, ExcecaoBancoVazio {
		DAO<T> f = new DAO<>();
		return f.exibir(t);
	}

	public void calcularPlano() {
		String escolha = "";
		while (!escolha.equals("0")) {
			Telas.telaPlanos();
			escolha = scan.next();
			switch (escolha) {
			case "40":
				System.out.println("Foi adicionado o plano Basico");
				planosNegocio.adicionarPlano(planos = new Planos(40.00));
				break;
			case "48":
				System.out.println("Foi adicionado o plano intermediario");
				planosNegocio.adicionarPlano(planos = new Planos(48.00));
				break;
			case "52":
				System.out.println("Foi adicionado o plano Hard-core");
				planosNegocio.adicionarPlano(planos = new Planos(52.00));
				break;
			case "0":
				System.out.println("mostrando resultados: ");
				mensagem();
				break;
			default:
				System.err.println("Plano invalido, tente novamente!");
				break;
			}
		}
	}

	public String IMC() {
		System.out.println("Entre com seu peso: ");
		double peso = scan.nextDouble();
		System.out.println("Entre com sua altura: ");
		double altura = scan.nextDouble();
		return Util.imc(peso, altura);
	}

	public T atualizar() {
		System.out.println("================= Digite CPF do cliente que deseja atualizar : ==================");
		String cpf = scan.next();
		while (Util.validarCPF(cpf) != true) {
			System.out.println("CPF no formato 'XXX.XXX.XXX-XX': ");
			cpf = scan.next();
		}
		// Fazer verificação se o Cliente no CPF existe.
		System.out.println("================= Atualizando: ==================");
		System.out.println("================= Digite nome: ==================");
		String nome = scan.next();
		System.out.println("================= Digite sexo: ==================");
		String sexo = scan.next();
		System.out.println("================= Digite peso: ==================");
		double peso = scan.nextDouble();
		System.out.println("================= Digite altura: ================");
		double altura = scan.nextDouble();
		System.out.println("================= Digite idade: =================");
		int idade = scan.nextInt();
		return (T) new Cliente(nome, cpf, sexo, peso, altura, idade, false);

	}

	public static void mensagem() {
		System.out.println("\nValor final por mês: R$ " + df.format(planosNegocio.calcularTotal()));
		System.out.println("Maior valor de Plano adicionado: " + planosNegocio.obterPlanoMaiorValor());
		System.out.println("Quantidade de planos: " + planosNegocio.qtdPlano());
		System.out.println("Quantidade de planos Hard-core: " + planosNegocio.qtdPlano(52.00) + "\n");
	}

}

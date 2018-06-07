package br.com.novaroma.apresentacao;

import java.util.Scanner;
import br.com.novaroma.util.Util;

public class Telas {
	private static Scanner scan = new Scanner(System.in);

	protected static boolean telaLogin() {
		System.out.println("======== Digite a Senha ========");
		String senha = scan.next();

		if (Util.validacao(senha) != true) {
			return false;
		}
		return true;
	}

	protected static void telaPrincipal() {
		System.out.println("========== 1 Para Funcionario =========");
		System.out.println("========== 2 Para Cliente =============");
		System.out.println("========== 0 Para SAIR ================");

	}

	protected static void telaMenuFuncionario() {
		System.out.println("========== 1 Para Cadastrar ===========");
		System.out.println("========== 2 Para Consultar ===========");
		System.out.println("========== 3 Para Atualizar ===========");
		System.out.println("========== 4 Para Remover =============");
		System.out.println("========== 5 para Exibir Func. ========");
		System.out.println("========== 6 Para Exibir Clientes =====");
		System.out.println("========== 0 para Finalizar ===========");
	}

	protected static void telaMenuCliente() {
		System.out.println("=========== 1 Para Cadastrar ==========");
		System.out.println("=========== 2 Para Consultar ==========");
		System.out.println("=========== 3 Para Atualizar ==========");
		System.out.println("=========== 4 Para Remover ============");
		System.out.println("=========== 5 para Exibir Clientes=====");
		System.out.println("=========== 6 para calcular o IMC =====");
		System.out.println("=== 7 para calcular Planos Familiar ===");
		System.out.println("=========== 0 para Finalizar ==========");
	}

	protected static void telaPlanos() {
		System.out.println("========= 40 - Plano Basico ===========");
		System.out.println("======== 48 - Plano Intermediario =====");
		System.out.println("======== 52 - Plano Hard-Core =========");
		System.out.println("========= 0 - Para Finalizar ==========");
	}

}

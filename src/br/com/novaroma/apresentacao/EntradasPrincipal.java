package br.com.novaroma.apresentacao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import br.com.novaroma.entidades.Cliente;
import br.com.novaroma.entidades.Funcionario;
import br.com.novaroma.excecoes.ExcecaoBancoVazio;
import br.com.novaroma.excecoes.ExcecaoNaoCadastrado;
import br.com.novaroma.negocio.ClienteNegocio;
import br.com.novaroma.negocio.FuncionarioNegocio;

public class EntradasPrincipal {

	private static Scanner scan = new Scanner(System.in);

	public static void Entrada() throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado, ExcecaoBancoVazio {
		FuncionarioNegocio<Funcionario> funcionarioNegocio = new FuncionarioNegocio<>();
		FuncionarioApresentacao<Funcionario> funcionarioApresentacao = new FuncionarioApresentacao<>();

		ClienteNegocio<Cliente> clienteNegocio = new ClienteNegocio<>();
		ClienteAprensentacao<Cliente> clienteApresentacao = new ClienteAprensentacao<>();
		if (Telas.telaLogin() == true) {
			try {
				String opcao = "";
				while (!opcao.equals("0")) {
					Telas.telaPrincipal();
					opcao = scan.next();

					if (opcao.equals("1")) {
						Telas.telaMenuFuncionario();
						opcao = scan.next();
						switch (opcao) {
						case "1":
							Funcionario f1 = (Funcionario) funcionarioApresentacao.preencher();
							System.out.println(funcionarioNegocio.cadastrar(f1));
							break;
						case "2":
							Funcionario f2 = (Funcionario) funcionarioApresentacao.consultar();
							funcionarioNegocio.consultar(f2);
							break;
						case "3":
							Funcionario f3 = (Funcionario) funcionarioApresentacao.atualizar();
							System.out.println(funcionarioNegocio.atualizar(f3));
							break;
						case "4":
							Funcionario f4 = (Funcionario) funcionarioApresentacao.remover();
							System.out.println(funcionarioNegocio.remover(f4));
							break;
						case "5":
							Funcionario f5 = new Funcionario(null, null, null, null, 0, 0, false);
							System.out.println(funcionarioApresentacao.exibirFuncionario(f5));
							break;
						case "6":
							Cliente f6 = new Cliente(null, null, null, 0, 0, 0, false);
							System.out.println(funcionarioApresentacao.exibirCliente(f6));
							break;
						default:
							System.err.println("Comando invalido!");
						}
					} else if (opcao.equals("2")) {
						Telas.telaMenuCliente();
						opcao = scan.next();
						switch (opcao) {
						case "1":
							Cliente c1 = (Cliente) clienteApresentacao.preencher();
							System.out.println(clienteNegocio.cadastrar(c1));
							break;
						case "2":
							Cliente c2 = (Cliente) clienteApresentacao.consultar();
							clienteNegocio.consultar(c2);
							break;
						case "3":
							Cliente c3 = (Cliente) clienteApresentacao.atualizar();
							System.out.println(clienteNegocio.atualizar(c3));
							break;
						case "4":
							Cliente c4 = (Cliente) clienteApresentacao.remover();
							System.out.println(clienteNegocio.remover(c4));
							break;
						case "5":
							Cliente c5 = new Cliente(null, null, null, 0, 0, 0, false);
							System.out.println(clienteApresentacao.exibir(c5));
							break;
						case "6":
							System.out.println(clienteApresentacao.IMC());
							break;
						case "7":
							clienteApresentacao.calcularPlano();
							break;
						default:
							System.err.println("Comando invalido!");
						}
					}
				}
			} catch (FileNotFoundException e) {
				System.err.println("O sistema não pode encontrar o banco especificado");
			} catch (ExcecaoNaoCadastrado e) {
				System.err.println(e.getMessage());
			} catch (ExcecaoBancoVazio e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

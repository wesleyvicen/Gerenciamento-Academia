package br.com.novaroma.apresentacao;

import java.io.IOException;

import br.com.novaroma.excecoes.ExcecaoBancoVazio;
import br.com.novaroma.excecoes.ExcecaoNaoCadastrado;

public class Principal extends Telas {
	public static void main(String[] args)
			throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado, ExcecaoBancoVazio {
		EntradasPrincipal.Entrada();
		System.out.println("Programa Finalizado!");
	}

}
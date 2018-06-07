package br.com.novaroma.negocio;

import java.io.IOException;
import java.io.Serializable;

import br.com.novaroma.dados.DAO;
import br.com.novaroma.entidades.Pessoa;
import br.com.novaroma.excecoes.ExcecaoNaoCadastrado;
import br.com.novaroma.interfaces.INegocio;

public class FuncionarioNegocio<T> implements INegocio<T, Serializable> {
	private DAO<T> dados = new DAO<>();

	public String cadastrar(T t) throws IOException, ClassNotFoundException {
		if (this.dados.consultaAlgo(((Pessoa) t).getCpf()) != null) {
			return "Erro: O funcionario já foi cadastrado!";
		}
		dados.cadastrar(t);
		return "Aluno cadastrado com sucesso!";
	}
	public String remover(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado {
		dados.remover(t);
		return "Funcionario removido com sucesso!";
	}

	public void consultar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado {
		dados.consultar(t);

	}

	public String atualizar(T f) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado {

		dados.atualizar(f);
		return "Funcionario atualizado";
	}
}

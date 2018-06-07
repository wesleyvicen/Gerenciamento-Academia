package br.com.novaroma.interfaces;

import java.io.IOException;
import java.io.Serializable;

import br.com.novaroma.excecoes.ExcecaoNaoCadastrado;

public interface INegocio<T, I extends Serializable> {
	public String cadastrar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;

	public String remover(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;

	public void consultar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;

	public String atualizar(T f) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;
}

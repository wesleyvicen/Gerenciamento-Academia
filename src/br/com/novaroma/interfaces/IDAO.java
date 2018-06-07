package br.com.novaroma.interfaces;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import br.com.novaroma.excecoes.ExcecaoBancoVazio;
import br.com.novaroma.excecoes.ExcecaoNaoCadastrado;

public interface IDAO<T, I extends Serializable> {
	public void cadastrar(T object) throws IOException, ClassNotFoundException;

	public ArrayList<T> exibir(T t) throws IOException, ClassNotFoundException, ExcecaoBancoVazio;

	public void remover(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;

	public void consultar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;

	public void atualizar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado;

	public void recuperaArquivo(T t) throws IOException, ClassNotFoundException;

	public void gravaArquivo(T t) throws IOException, ClassNotFoundException;
}

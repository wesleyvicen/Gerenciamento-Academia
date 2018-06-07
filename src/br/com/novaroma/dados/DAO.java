package br.com.novaroma.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import br.com.novaroma.entidades.Pessoa;
import br.com.novaroma.excecoes.ExcecaoBancoVazio;
import br.com.novaroma.excecoes.ExcecaoNaoCadastrado;
import br.com.novaroma.interfaces.IDAO;

public class DAO<T> implements IDAO<T, Serializable> {
	ArrayList<T> colecao;
	Set<T> colecaoSet;

	public void cadastrar(T t) throws IOException, ClassNotFoundException {
		File arquivo = new File(t.getClass().getSimpleName() + ".txt");
		if (arquivo.exists()) {
			recuperaArquivo(t);
		} else {
			arquivo.createNewFile();
			colecao = new ArrayList<T>();
		}
		colecao.add(t);
		gravaArquivo(t);

	}

	public ArrayList<T> exibir(T t) throws IOException, ClassNotFoundException, ExcecaoBancoVazio {
		File arquivo = new File(t.getClass().getSimpleName() + ".txt");
		if (arquivo.exists()) {
			recuperaArquivo(t);

		} else {
			throw new ExcecaoBancoVazio("Banco Vazio");

		}
		return colecao;

	}

	public void remover(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado {
		recuperaArquivo(t);
		for (int i = 0; i < colecao.size(); i++) {
			if (((Pessoa) t).getCpf().equalsIgnoreCase(((Pessoa) colecao.get(i)).getCpf())) {
				colecao.remove(i);
				break;
			} else {
				throw new ExcecaoNaoCadastrado("Não existe no Banco");

			}
		}

		gravaArquivo(t);
	}

	public void consultar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado {
		recuperaArquivo(t);
		for (int i = 0; i < colecao.size(); i++) {
			if (((Pessoa) t).getCpf().equals(((Pessoa) colecao.get(i)).getCpf())) {
				System.out.println(colecao.get(i));
				break;
			} else {
				throw new ExcecaoNaoCadastrado("Não existe no Banco");

			}
		}
		gravaArquivo(t);
	}

	public Object consultaAlgo(String cpf) {
		return null;
	}

	public boolean consultaCPF(T t) throws ClassNotFoundException, IOException, ExcecaoNaoCadastrado {
	recuperaArquivo(t);
		for (int i = 0; i < colecao.size(); i++) {
			if (((Pessoa) t).getCpf().equals(((Pessoa) colecao.get(i)).getCpf())) {
				return true;
			}

		}
		gravaArquivo(t);
		return false;
	}

	public void atualizar(T t) throws IOException, ClassNotFoundException, ExcecaoNaoCadastrado {
		recuperaArquivo(t);
		for (int i = 0; i < colecao.size(); i++) {
			if (((Pessoa) t).getCpf().equalsIgnoreCase(((Pessoa) colecao.get(i)).getCpf())) {
				colecao.remove(i);
				colecao.add(t);
				break;
			} else {
				throw new ExcecaoNaoCadastrado("Não existe no Banco");

			}

		}
		gravaArquivo(t);
	}

	public void recuperaArquivo(T t) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(t.getClass().getSimpleName() + ".txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		colecao = (ArrayList<T>) ois.readObject();
		ois.close();

	}

	public void gravaArquivo(T t) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream(t.getClass().getSimpleName() + ".txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(colecao);
		oos.close();
	}
}
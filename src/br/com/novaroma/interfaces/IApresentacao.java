package br.com.novaroma.interfaces;

public interface IApresentacao<T> {
	public T preencher();

	public T remover();

	public T consultar();

	public T atualizar();
}

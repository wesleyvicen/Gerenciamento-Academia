package br.com.novaroma.negocio;

import java.util.HashMap;
import java.util.Map;

import br.com.novaroma.entidades.Planos;

public class PlanosNegocio {
	Map<Double, Integer> planos = new HashMap<>();

	public PlanosNegocio() {
		planos.put(40.00, 0);
		planos.put(48.00, 0);
		planos.put(52.00, 0);
	}

	public Map<Double, Integer> getMoedas() {
		return planos;
	}

	public void setPlanos(Map<Double, Integer> planos) {
		this.planos = planos;
	}

	public void adicionarPlano(Planos m) {
		Double chave = m.getValor();
		Integer valor = planos.get(chave) + 1;
		planos.put(chave, valor);
		// planos.put(m.getValor(), planos.get(m.getValor()) + 1);
	}

	public double calcularTotal() {
		double soma = 0;
		for (Double valorPlano : planos.keySet()) {
			soma += planos.get(valorPlano) * valorPlano;
		}
		return soma;

	}

	public int qtdPlano() {
		int qtdPlanos = 0;
		for (Integer qtd : planos.values()) {
			qtdPlanos += qtd;
		}
		return qtdPlanos;
	}

	public int qtdPlano(double valor) {
		return planos.get(valor);
	}

	public double obterPlanoMaiorValor() {
		double maior = 0;
		for (Double valorPlano : planos.keySet()) {
			if (valorPlano > maior && planos.get(valorPlano) > 0) {
				maior = valorPlano;
			}
		}
		return maior;
	}
}

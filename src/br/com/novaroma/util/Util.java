package br.com.novaroma.util;

public class Util {

	public static boolean validacao(String senha) {

		if (senha.equals("123456")) {
			return true;
		}
		return false;
	}

	public static boolean validarCPF(String i) {

		String padrao = "\\d{11}";

		if (i.matches(padrao)) {
			return true;
		} else

		return false;
	}

	public static String imc(double peso, double altura) {
		double imc = (altura * altura) / peso;
		if (imc >= 18) {
			return " Desnutrido";
		} else if (imc <= 24.9) {
			return " Peso saudável";
		} else if (imc <= 29.9) {
			return " Sobrepeso";
		} else if (imc <= 34.9) {
			return " Obesidade Grau I";
		} else if (imc <= 39.9) {
			return " Obesidade Mórbida. (Grau II e III)";
		} else if (imc <= 40) {
			return " Super Obesidade. (Grau IV)";
		}
		return " Invalido";

	}
}

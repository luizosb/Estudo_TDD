package com.gft.desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {

	public CalculadoraDescontoPrimeiraFaixa(CalculadoraFaixaDesconto calcProximo) {
		super(calcProximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		if(valorTotal > 300.0 && valorTotal <= 800.0) {
			return valorTotal * 0.04;
		}
		return -1;
	}

}

package com.gft.desconto;

public class SemDesconto extends CalculadoraFaixaDesconto{

	public SemDesconto(CalculadoraFaixaDesconto calcProximo) {
		super(calcProximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}

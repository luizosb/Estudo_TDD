package com.gft.desconto;

public abstract class CalculadoraFaixaDesconto {

	private CalculadoraFaixaDesconto calcProximo;

	public CalculadoraFaixaDesconto(CalculadoraFaixaDesconto calcProximo) {
		this.calcProximo = calcProximo;
	}
	
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);
		
		if(desconto == -1) {
			return calcProximo.desconto(valorTotal);
		}
		return desconto;
	}

	protected abstract double calcular(double valorTotal);
	
}

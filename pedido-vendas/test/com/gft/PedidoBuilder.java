package com.gft;

import com.gft.desconto.CalculadoraDescontoPrimeiraFaixa;
import com.gft.desconto.CalculadoraDescontoSegundaFaixa;
import com.gft.desconto.CalculadoraDescontoTerceiraFaixa;
import com.gft.desconto.CalculadoraFaixaDesconto;
import com.gft.desconto.SemDesconto;

public class PedidoBuilder {
	
	private Pedido instancia;
	
	public PedidoBuilder() {
		CalculadoraFaixaDesconto calcFaixaDesconto = new CalculadoraDescontoTerceiraFaixa(
														new CalculadoraDescontoSegundaFaixa(
															new CalculadoraDescontoPrimeiraFaixa(
																new SemDesconto(null))));
			
		instancia = new Pedido(calcFaixaDesconto);
	}
	
	public PedidoBuilder comItem(double preco, int qtd) {
		instancia.adicionarItemALista(new ItemPedido("Gerado", preco, qtd));
		return this;
	}
	

	public Pedido construir() {
		return instancia;
	}
}

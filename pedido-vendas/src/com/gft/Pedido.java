package com.gft;

import java.util.ArrayList;
import java.util.List;

import com.gft.desconto.CalculadoraFaixaDesconto;

public class Pedido {
	
	//private double valorTotal; 
	//private double desconto;

	private List<ItemPedido> itens = new ArrayList<>();
	
	private CalculadoraFaixaDesconto calcFaixaDesconto;
	
	public Pedido(CalculadoraFaixaDesconto calcFaixaDesconto) {
		this.calcFaixaDesconto = calcFaixaDesconto;
	}
	
	public void validarQtdDeItens(ItemPedido itemPedido) {
		if (itemPedido.qtd < 0) {
			throw new QuantidadeDeItensInvalidaExpection();
		}
	}
	
	public void adicionarItemALista(ItemPedido itemPedido) {
		validarQtdDeItens(itemPedido);
		itens.add(itemPedido);
	}
	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getPreco() * i.getQtd()).sum();
		double desconto = calcFaixaDesconto.desconto(valorTotal);
		
		return new ResumoPedido(valorTotal, desconto);
	}

}

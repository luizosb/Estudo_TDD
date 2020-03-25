package com.gft;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	//private double valorTotal; 
	private double desconto;

	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionarItemALista(ItemPedido itemPedido) {
		itens.add(itemPedido);
	}

	public Double valorTotal() {
		//valorTotal += itemPedido.getPreco() * itemPedido.getQtd();		
		return itens.stream().mapToDouble(i -> i.getPreco() * i.getQtd()).sum();
	}

	public Double desconto() {
		double valorTotal = valorTotal();
		if(valorTotal >= 300.0) {
			desconto = valorTotal * 0.04;
		} else if (valorTotal >= 800.0) {
			desconto = valorTotal * 0.06;
		} else if (valorTotal >= 1000.0) {
			desconto = valorTotal * 0.08;
		}
		return desconto;
	}

}

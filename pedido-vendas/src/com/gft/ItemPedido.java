package com.gft;

public class ItemPedido {
	
	public String desc;
	public double preco;
	public int qtd;

	public ItemPedido(String desc, double preco, int qtd) {
		this.desc = desc;
		this.preco = preco;
		this.qtd = qtd;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
}
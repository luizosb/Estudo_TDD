package com.gft;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {
	
	private Pedido pedido;	

	@Before
	public void setup() {
		pedido = new Pedido();
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		assertEquals(valorTotal, pedido.valorTotal(), 0.001);
		assertEquals(desconto, pedido.desconto(), 0.001);
	}

	@Test
	public void deveAdicionarUmPedidoNaLista() throws Exception{
		pedido.adicionarItemALista(new ItemPedido("Sabonete", 3.0, 10));
	}
	
	@Test
	public void deveCalculadorValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.adicionarItemALista(new ItemPedido("Sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularDoisItens() throws Exception{
		pedido.adicionarItemALista(new ItemPedido("Sabonete", 3.0, 5));
		pedido.adicionarItemALista(new ItemPedido("Shampoo", 9.0, 2));
		
		assertResumoPedido(33.0, 0);
	}
	
	@Test
	public void deveAplicarDescontoNa1Faixa() throws Exception{
		pedido.adicionarItemALista(new ItemPedido("Condicionador", 15.0, 21));
		assertResumoPedido(315.0, 12.6);
	}
	

}

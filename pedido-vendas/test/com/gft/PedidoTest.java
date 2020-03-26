package com.gft;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {
	
	private PedidoBuilder pedido;	

	@Before
	public void setup() {
		pedido = new PedidoBuilder();
		
	}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.construir().resumo();

	//	assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.001);
	//	assertEquals(desconto, resumoPedido.getDesconto(), 0.001);
		assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
	
	}

	@Test
	public void deveCalculadorValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	public void deveCalcularResumoParaUmItemSemDesconto() throws Exception {
		pedido.comItem(5.0, 5);
		assertResumoPedido(25.0, 0.0);
	}
	
	@Test
	public void deveCalcularDoisItens() throws Exception{
		//pedido.adicionarItemALista(new ItemPedido("Sabonete", 3.0, 5));
		//pedido.adicionarItemALista(new ItemPedido("Shampoo", 9.0, 2));
		pedido.comItem(3.0, 5)
			  .comItem(9.0, 2);
		
		assertResumoPedido(33.0, 0);
	}
	
	@Test
	public void deveAplicarDescontoNa1Faixa() throws Exception{
		//pedido.adicionarItemALista(new ItemPedido("Condicionador", 15.0, 21));
		pedido.comItem(15.0, 21);
		assertResumoPedido(315.0, 12.6);
	}
	
	@Test
	public void deveAplicarDescontoNa2Faixa() throws Exception{
		//pedido.adicionarItemALista(new ItemPedido("Maquiagem", 50.0, 18));
		pedido.comItem(50.0, 18);
		assertResumoPedido(900.0, 54.0);
	}
	
	@Test
	public void deveAplicarDescontoNa3Faixa() throws Exception{
		pedido.comItem(120.0, 10);
		assertResumoPedido(1200.0, 96.0);
	}
	
	@Test(expected = QuantidadeDeItensInvalidaExpection.class)
	public void naoAceitarPedidosComQtdsNegativos() throws Exception {
		pedido.comItem(4.0, -10);
	}

}

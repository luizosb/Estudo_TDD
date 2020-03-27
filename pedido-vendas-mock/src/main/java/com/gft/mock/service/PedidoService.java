package com.gft.mock.service;

import java.util.List;

import com.gft.mock.model.Pedido;
import com.gft.mock.model.StatusPedido;
import com.gft.mock.repository.Pedidos;

public class PedidoService {

	
	private List<AcaoLancamentoPedido> acoes;
	private Pedidos pedidos;

	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {
		this.acoes = acoes;
		this.pedidos = pedidos;
	}

	public double lancar(Pedido pedido) {
		double imposto = pedido.getValor() * 0.1;
		
		acoes.forEach(a -> a.executar(pedido));
		
		return imposto;
	}

	public Pedido pagar(Long codigo) {
		Pedido pedido = pedidos.buscarPeloCodigo(codigo);
		if(pedido.getStatus().equals(StatusPedido.PENDENTE)==false) {
			throw new PedidoInvalidoException();
		}
		pedido.setStatus(StatusPedido.PAGO);
		return pedido;
	}

	
}

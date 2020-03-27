package com.gft.mock.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.gft.mock.email.NotificarEmail;
import com.gft.mock.model.Pedido;
import com.gft.mock.model.StatusPedido;
import com.gft.mock.model.builder.PedidoBuilder;
import com.gft.mock.repository.Pedidos;
import com.gft.mock.sms.NotificarSms;

public class PedidoServiceTest {

	private PedidoService pedidoServ;

	@Mock
	private Pedidos pedidos;

	@Mock
	private NotificarEmail email;

	@Mock
	private NotificarSms sms;

	private Pedido pedido;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		List<AcaoLancamentoPedido> acoes = Arrays.asList(pedidos, email, sms);
		pedidoServ = new PedidoService(pedidos, acoes);
		pedido = new PedidoBuilder().comValor(100.0).para("Luiz", "luiz@gft.com", "9999-0000").construir();
	}

	@Test
	public void deveCalcularOImposto() throws Exception {

		double imposto = pedidoServ.lancar(pedido);
		assertEquals(10.0, imposto, 0.00001);

	}

	@Test
	public void deveSalvarNoBancoDeDados() throws Exception {
		pedidoServ.lancar(pedido);
		verify(pedidos).executar(pedido);
	}

	@Test
	public void deveNotificarOEmail() throws Exception {
		pedidoServ.lancar(pedido);
		verify(email).executar(pedido);
	}

	@Test
	public void deveNotificarOSMS() throws Exception {
		pedidoServ.lancar(pedido);
		verify(sms).executar(pedido);
	}

	@Test
	public void devePagarPedidoPendente() throws Exception {
		Long codigoPedido = 135L;

		Pedido pedidoPendente = new Pedido();
		pedidoPendente.setStatus(StatusPedido.PENDENTE);
		when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

		Pedido pedidoPago = pedidoServ.pagar(codigoPedido);

		assertEquals(StatusPedido.PENDENTE, pedidoPago.getStatus());
	}

	@Test(expected = PedidoInvalidoException.class)
	public void deveNegarPagamento() throws Exception {
		Long codigoPedido = 135L;

		Pedido pedidoPendente = new Pedido();
		pedidoPendente.setStatus(StatusPedido.PAGO);
		when(pedidos.buscarPeloCodigo(codigoPedido)).thenReturn(pedidoPendente);

		pedidoServ.pagar(codigoPedido);

		

	}
}

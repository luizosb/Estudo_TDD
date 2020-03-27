package com.gft.mock.email;

import com.gft.mock.model.Pedido;
import com.gft.mock.service.AcaoLancamentoPedido;

public class NotificarEmail implements AcaoLancamentoPedido{

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviou o E-MAIL");
	}

}

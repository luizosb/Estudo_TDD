package com.gft.mock.sms;

import com.gft.mock.model.Pedido;
import com.gft.mock.service.AcaoLancamentoPedido;

public class NotificarSms implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviou o SMS");
		
	}

}

package com.gft.services;

import com.gft.model.Passageiro;
import com.gft.model.Voo;

public class PrecoPassagemService {

	public double calcular(Passageiro passageiro, Voo voo) {
		return passageiro.getTipo().getCalculadora().calcular(voo);
	}
}

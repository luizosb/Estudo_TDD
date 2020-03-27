package com.gft.model;

import com.gft.services.CalculadoraPrecoPassagem;
import com.gft.services.PrecoPassagemGold;
import com.gft.services.PrecoPassagemSilver;

public enum TipoPassageiro {

	GOLD(new PrecoPassagemGold()),
	SILVER(new PrecoPassagemSilver());
	
	CalculadoraPrecoPassagem calculadoraPrecoPassagem;
	
	TipoPassageiro(CalculadoraPrecoPassagem calculadoraPrecoPassagem){
		this.calculadoraPrecoPassagem = calculadoraPrecoPassagem;
	}
	
	public CalculadoraPrecoPassagem getCalculadora() {
		return calculadoraPrecoPassagem;
	}
	
}

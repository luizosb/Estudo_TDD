package com.gft.services;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gft.model.Passageiro;
import com.gft.model.TipoPassageiro;
import com.gft.model.Voo;

public class PrecoPassagemServiceTest {
	
	private PrecoPassagemService precoPassagemServ;
	
	@Before
	public void setup() {
		precoPassagemServ = new PrecoPassagemService();		
	}
	
	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemServ.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}

	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Robson", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Robson", TipoPassageiro.GOLD);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo, 680.0);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Josue", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 100.0);
		assertValorPassagem(passageiro, voo, 94);
	}
	
	@Test
	public void deveCalcularValorPassagemParaPassageiroSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Josue", TipoPassageiro.SILVER);
		Voo voo = new Voo("São Paulo", "Rio de Janeiro", 800.0);
		assertValorPassagem(passageiro, voo, 720);
	}

}

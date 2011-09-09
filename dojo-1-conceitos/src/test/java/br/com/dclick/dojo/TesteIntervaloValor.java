package br.com.dclick.dojo;

import junit.framework.Assert;

import org.junit.Test;

import br.com.dclick.dojo.conceitos.Operador;
import br.com.dclick.dojo.conceitos.vo.IntervaloValor;

public class TesteIntervaloValor {

	@Test
	public void testarIntervaloValor(){
		IntervaloValor valor = new IntervaloValor(Operador.MENOR, 3, "RUIM");
		IntervaloValor valor2 = new IntervaloValor(Operador.MENOR, 3, "RUIM");
		Assert.assertFalse(valor.validaIntervaloSimples(valor2));
	}
	
	@Test
	public void testarIntervaloValor1(){
		IntervaloValor valor = new IntervaloValor(Operador.MENOR, 3, "RUIM");
		IntervaloValor valor2 = new IntervaloValor(Operador.MENOR, 8, "RUIM");
		Assert.assertFalse(valor.validaIntervaloSimples(valor2));
	}
	
	@Test
	public void testarIntervaloValor2(){
		IntervaloValor valor = new IntervaloValor(Operador.MENOR, 3, "RUIM");
		IntervaloValor valor2 = new IntervaloValor(Operador.MAIOR, 3, "REGULAR");
		Assert.assertTrue(valor.validaIntervaloSimples(valor2));
	}
	
	@Test
	public void testarIntervaloValor3(){
		IntervaloValor valor = new IntervaloValor(Operador.MENOR, 3, "RUIM");
		IntervaloValor valor2 = new IntervaloValor(Operador.MAIOR_IGUAL, 3, "REGULAR");
		Assert.assertTrue(valor.validaIntervaloSimples(valor2));
	}
	
	@Test
	public void testarIntervaloValor4(){
		IntervaloValor valor = new IntervaloValor(Operador.MENOR_IGUAL, 3, "RUIM");
		IntervaloValor valor2 = new IntervaloValor(Operador.MAIOR_IGUAL, 3, "REGULAR");
		Assert.assertFalse(valor.validaIntervaloSimples(valor2));
	}
	
	@Test
	public void testarIntervaloValor5(){
		IntervaloValor valor = new IntervaloValor(Operador.MENOR, 4, "RUIM");
		IntervaloValor valor2 = new IntervaloValor(Operador.MAIOR_IGUAL, 3, "REGULAR");
		Assert.assertFalse(valor.validaIntervaloSimples(valor2));
	}
}

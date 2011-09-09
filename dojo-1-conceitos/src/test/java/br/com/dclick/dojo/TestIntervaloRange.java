package br.com.dclick.dojo;

import org.junit.Assert;
import org.junit.Test;

import br.com.dclick.dojo.conceitos.Operador;
import br.com.dclick.dojo.conceitos.vo.IntervaloRange;
import br.com.dclick.dojo.conceitos.vo.IntervaloValor;

public class TestIntervaloRange {
	@Test
	public void testeIntervaloFechado(){
		IntervaloValor intervaloValor = new IntervaloValor(Operador.MENOR, 3, "Ruim");
		IntervaloRange intervaloRange = new IntervaloRange(Operador.MENOR, 5, Operador.MAIOR, 3, "Ruim");
		
		Assert.assertTrue(intervaloRange.validaIntevalo(intervaloValor));
	}
	@Test
	public void testeIntervaloSimplesComRange()
	{
		IntervaloValor intervaloValor = new IntervaloValor(Operador.MENOR, 3, "Ruim");
		IntervaloRange intervaloRange = new IntervaloRange(Operador.MENOR, 5, Operador.MAIOR, 3, "Ruim");
		
		Assert.assertTrue(intervaloValor.validaIntevalo(intervaloRange));
	}
	
	@Test
	public void testeIntervaloSimplesComRangeErro()
	{
		IntervaloValor intervaloValor = new IntervaloValor(Operador.MENOR_IGUAL, 3, "Ruim");
		IntervaloRange intervaloRange = new IntervaloRange(Operador.MENOR, 5, Operador.MAIOR_IGUAL, 3, "Ruim");
		
		Assert.assertFalse(intervaloValor.validaIntevalo(intervaloRange));
	}
	
	@Test
	public void testeIntervaloRangeComSimplesErro()
	{
		IntervaloValor intervaloValor = new IntervaloValor(Operador.MENOR_IGUAL, 3, "Ruim");
		IntervaloRange intervaloRange = new IntervaloRange(Operador.MENOR, 5, Operador.MAIOR_IGUAL, 3, "Ruim");
		
		Assert.assertFalse(intervaloRange.validaIntevalo(intervaloValor));
	}
	
	@Test
	public void testeIntervaloRangeComRangeFechado()
	{
		IntervaloRange intervaloRange1 = new IntervaloRange(Operador.MAIOR_IGUAL, 3, Operador.MENOR, 5, "Ruim");
		IntervaloRange intervaloRange2 = new IntervaloRange(Operador.MAIOR, 0, Operador.MENOR, 3, "Ruim");
		
		Assert.assertTrue(intervaloRange1.validaIntevalo(intervaloRange2));
		Assert.assertTrue(intervaloRange2.validaIntevalo(intervaloRange1));
	}
}

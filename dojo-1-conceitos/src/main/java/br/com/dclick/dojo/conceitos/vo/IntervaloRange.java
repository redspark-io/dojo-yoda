package br.com.dclick.dojo.conceitos.vo;

import br.com.dclick.dojo.conceitos.Operador;

public class IntervaloRange implements Intervalo {
	public IntervaloRange(Operador operador1, double valor1, Operador operador2, double valor2, String conceito) {
		this.intervaloValor1 = new IntervaloValor(operador1, valor1, conceito);
		this.intervaloValor2 = new IntervaloValor(operador2, valor2, conceito);
	}
	private IntervaloValor intervaloValor1;
	private IntervaloValor intervaloValor2;
	
	public IntervaloValor getIntervaloValor1() {
		return intervaloValor1;
	}
	public void setIntervaloValor1(IntervaloValor intervaloValor1) {
		this.intervaloValor1 = intervaloValor1;
	}
	public IntervaloValor getIntervaloValor2() {
		return intervaloValor2;
	}
	public void setIntervaloValor2(IntervaloValor intervaloValor2) {
		this.intervaloValor2 = intervaloValor2;
	}
	
	@Override
	public boolean validaIntervaloRange(IntervaloRange intervaloRange) {
		IntervaloValor menor;
		IntervaloValor maior;
		if (this.ehIntervaloFechado()){
			
			if(intervaloRange.ehIntervaloFechado())
			{
				menor = identificaMenor();
				maior = identificaMaior();
				
				if(intervaloRange.getIntervaloValor1().getValor() < menor.getValor() 
						&& intervaloRange.getIntervaloValor2().getValor() < menor.getValor())
				{
					return true;
				}
				else if(intervaloRange.getIntervaloValor1().getValor() > maior.getValor() 
						&& intervaloRange.getIntervaloValor2().getValor() > maior.getValor())
				{
					return true;
				}
				else
				{
					if (menor.hasEqual()){
						if (intervaloRange.intervaloValor1.getValor() == menor.getValor()){ 
							if (intervaloRange.intervaloValor1.hasEqual()){
								return false;
							}
							else{
								return true;
							}
						}
						
						if (intervaloRange.intervaloValor2.getValor() == menor.getValor()){
							if (intervaloRange.intervaloValor2.hasEqual()){
								return false;
							}
							else{
								return true;
							}
						}
						
					}
					else if(maior.hasEqual()){
						if (intervaloRange.intervaloValor1.getValor() == maior.getValor()){ 
							if (intervaloRange.intervaloValor1.hasEqual()){
								return false;
							}
							else{
								return true;
							}
						}
						
						if (intervaloRange.intervaloValor2.getValor() == maior.getValor()){
							if (intervaloRange.intervaloValor2.hasEqual()){
								return false;
							}
							else{
								return true;
							}
						}
					}
					
						
				}
					
			}
		}
		else
		{
			
		}
		return true;
	}
	@Override
	public boolean validaIntervaloSimples(IntervaloValor intervaloValor) {
		
		if (this.ehIntervaloFechado()){
			if (intervaloValor1.getDirecao() != intervaloValor.getDirecao()){
				return intervaloValor1.validaIntervaloSimples(intervaloValor);
			}
			else{
				return intervaloValor2.validaIntervaloSimples(intervaloValor);
			}
		}
		else
		{
			return false;
		}
	}
	
	private IntervaloValor identificaMenor()
	{
		return intervaloValor1.getValor() < intervaloValor2.getValor() ? intervaloValor1 : intervaloValor2;
	}
	
	private IntervaloValor identificaMaior()
	{
		return intervaloValor1.getValor() > intervaloValor2.getValor() ? intervaloValor1 : intervaloValor2;
	}
	
	private boolean ehIntervaloFechado(){
		return !intervaloValor1.validaIntervaloSimples(intervaloValor2);
	}
	
	@Override
	public boolean validaIntevalo(Intervalo intervalo) {
		// TODO Auto-generated method stub
		return intervalo.validaIntervaloRange(this);
	}
	@Override
	public String getConceito() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return intervaloValor1.toString() + " " + intervaloValor2.toString();
	}
}

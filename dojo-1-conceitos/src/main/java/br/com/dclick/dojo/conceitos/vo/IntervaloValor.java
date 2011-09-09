package br.com.dclick.dojo.conceitos.vo;

import br.com.dclick.dojo.conceitos.Operador;

public class IntervaloValor implements Intervalo {
	private Operador operador;
	private double valor;
	private String conceito;
	private Direcao direcao;

	public Direcao getDirecao() {
		return direcao;
	}

	public IntervaloValor(Operador operador, double valor, String conceito) {
		super();
		this.operador = operador;
		this.valor = valor;
		this.conceito = conceito;
		direcao = DirecaoUtil.getDirecao(this);
	}

	public String getConceito() {
		return conceito;
	}

	public void setConceito(String conceito) {
		this.conceito = conceito;
	}

	public Operador getOperador() {
		return operador;
	}

	public void setOperador(Operador operador) {
		this.operador = operador;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public boolean validaIntervaloRange(IntervaloRange intervaloRange) {
		return intervaloRange.validaIntervaloSimples(this);
	}

	@Override
	public boolean validaIntervaloSimples(IntervaloValor intervaloValor) {
		if (this.direcao.equals(intervaloValor.direcao)) {
			return false;
		} else if (this.valor != intervaloValor.valor) {
			IntervaloValor maior = this.valor > intervaloValor.valor ? this
					: intervaloValor;
			if (maior.direcao == Direcao.ESQUERDA) {
				return false;
			}
			return true;
		}
		else
		{
			if(this.operador == Operador.MAIOR_IGUAL && intervaloValor.operador == Operador.MENOR_IGUAL)
			{
				return false;
			}
			if(this.operador == Operador.MENOR_IGUAL && intervaloValor.operador == Operador.MAIOR_IGUAL)
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean hasEqual(){
		return operador == Operador.MAIOR_IGUAL||operador == Operador.MENOR_IGUAL;
	}

	@Override
	public boolean validaIntevalo(Intervalo intervalo) {
		// TODO Auto-generated method stub
		return intervalo.validaIntervaloSimples(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return operador + " " + valor;
	}
}

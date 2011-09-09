package br.com.dclick.dojo.conceitos.vo;

public interface Intervalo {
	String getConceito();
	boolean validaIntevalo(Intervalo intervalo);
	boolean validaIntervaloSimples(IntervaloValor intervaloValor);
	boolean validaIntervaloRange(IntervaloRange intervaloRange);
}

package br.com.dclick.dojo.conceitos.vo;

import static br.com.dclick.dojo.conceitos.Operador.*;

public class DirecaoUtil {

	public static Direcao getDirecao(IntervaloValor intervalo) {
		if (intervalo.getOperador() == MAIOR
				|| intervalo.getOperador() == MAIOR_IGUAL)
		{
			return Direcao.DIREITA;
		}
		else
		{
			return Direcao.ESQUERDA;
		}
	}
}

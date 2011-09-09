package br.com.dclick.dojo.conceitos;

import java.util.ArrayList;
import java.util.List;

import br.com.dclick.dojo.conceitos.vo.Intervalo;
import br.com.dclick.dojo.conceitos.vo.IntervaloRange;
import br.com.dclick.dojo.conceitos.vo.IntervaloValor;

public class GerenciamentoConceitos implements GerenciadorConceitos {

	private List<Intervalo> intervalos = new ArrayList<Intervalo>();

	@Override
	public boolean adicionaConceito(Operador operador1, double valor1,
			Operador operador2, Double valor2) {
		Intervalo intervalo;
		if (operador2 == null) {
			String conceito = "RUIM";
			if (intervalos.size() == 1) {
				conceito = "REGULAR";
			} else if (intervalos.size() == 2) {
				conceito = "BOM";
			}
			intervalo = new IntervaloValor(operador1, valor1, conceito);
			if(validaIntervaloSimples(intervalo))
			{
				intervalos.add(intervalo);
				return true;
			}
		} else {
			//intervalo = new IntervaloRange();
		}

		return false;
	}

	private boolean validaIntervaloSimples(Intervalo intervalo) {
		
		if(intervalos.size() == 0)
			return true;
		else
		{
			for (Intervalo inter : intervalos) {
				if(!inter.validaIntevalo(intervalo))
				{
					return false;
				}
			}
			
		}
		
		return true;
	}

	@Override
	public String atribuiConceito(double valor) {
		// TODO Auto-generated method stub
		return null;
	}

}

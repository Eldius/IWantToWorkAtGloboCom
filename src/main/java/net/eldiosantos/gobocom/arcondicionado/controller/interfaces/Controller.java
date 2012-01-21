package net.eldiosantos.gobocom.arcondicionado.controller.interfaces;

import java.math.BigDecimal;

/**
 * Interface que define a interação com o controlador do aparelho.
 * 
 * @author Eldius
 * 
 */
public interface Controller {

	/**
	 * Retorna o valor total até desde o início da utilização.
	 * 
	 * @return
	 */
	public abstract BigDecimal custoTotal();

	/**
	 * Inicia o controle de temperatura.
	 * 
	 * @param tempInicial
	 *            Temperatura inicial.
	 * @param tempFinal
	 *            Temperatura final.
	 * @param minutos
	 *            Tempo em minutos.
	 * @return Retorna o custo da chamada.
	 */
	public abstract BigDecimal manterTemperatura(float tempInicial,
			float tempFinal, int minutos);
}

package net.eldiosantos.gobocom.arcondicionado;

import net.eldiosantos.gobocom.arcondicionado.interfaces.ArCondicionado;

import org.apache.log4j.Logger;

/**
 * Implementação para um ar condicionado específico.
 * 
 * @author Eldius
 * 
 */
public class ArCondicionadoImpl implements ArCondicionado {

	private static Logger logger = Logger.getLogger(ArCondicionadoImpl.class);

	private boolean ligado = false;

	public boolean isLigado() {
		return this.ligado;
	}

	public void reduz_um_grau() {

		StringBuffer sb = new StringBuffer("Status: ").append(ligado);

		logger.info(sb.toString());

		if (!this.ligado) {
			logger.info("Ligando...");
		}

		this.ligado = true;
	}

}

package net.eldiosantos.gobocom.arcondicionado.controller;

import java.math.BigDecimal;

import net.eldiosantos.gobocom.arcondicionado.controller.interfaces.Controller;
import net.eldiosantos.gobocom.arcondicionado.interfaces.ArCondicionado;

import org.apache.log4j.Logger;

public class DefaultController implements Controller {

	private static Logger logger = Logger.getLogger(DefaultController.class);

	private ArCondicionado arCondicionado;
	private BigDecimal valor = new BigDecimal(0.00);

	private float tempAtual;

	public DefaultController(ArCondicionado arCondicionado) {
		super();
		this.arCondicionado = arCondicionado;
		valor.setScale(2);
	}

	public BigDecimal custoTotal() {
		return this.valor;
	}

	public BigDecimal manterTemperatura(float tempInicial, float tempFinal,
			int minutos) {

		this.tempAtual = tempInicial;
		BigDecimal valorAtual = new BigDecimal(0.00);
		float margem = tempFinal + 2;

		valorAtual.setScale(2);

		// Baixar temperatura para a desejada.
		while (tempAtual > tempFinal) {
			valorAtual = valorAtual.add(this.baixarTemperatura());
		}

		// Manter a temperatura dentro da margem aceitável pelo tempo
		// determinado.
		for (int t = 0; t < minutos; t++) {
			tempAtual += 0.5;

			// Se a temperatura não estiver abaixo da margem baixar a
			// temperatura.
			if (!(tempAtual < margem)) {
				valorAtual = valorAtual.add(this.baixarTemperatura());
			}

			logger.debug("Valor atual: " + valorAtual);
		}

		this.valor = this.valor.add(valorAtual);

		return valorAtual;
	}

	private BigDecimal baixarTemperatura() {
		BigDecimal resposta = new BigDecimal(0.00);
		resposta.setScale(2);

		if (arCondicionado.isLigado()) {
			resposta = resposta.add(new BigDecimal("0.10"));
		} else {
			resposta = resposta.add(new BigDecimal("0.50"));
		}

		arCondicionado.reduz_um_grau();

		this.tempAtual--;

		logger.debug("Temperatura: " + tempAtual);
		logger.debug("Custo: " + resposta);

		return resposta;
	}
}

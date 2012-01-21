package net.eldiosantos.gobocom.arcondicionado.controller;

import java.math.BigDecimal;

import net.eldiosantos.gobocom.arcondicionado.interfaces.ArCondicionado;

public class DefaultController implements Controller {

	private ArCondicionado arCondicionado;
	private BigDecimal valor = new BigDecimal(0.00);

	private float tempAtual;

	public DefaultController(ArCondicionado arCondicionado) {
		super();
		this.arCondicionado = arCondicionado;
	}

	public BigDecimal costoTotal() {
		return this.valor;
	}

	public BigDecimal manterTemperatura(float tempInicial, float tempFinal,
			int minutos) {

		this.tempAtual = tempInicial;
		BigDecimal valorAtual = new BigDecimal(0.00);
		float margem = tempFinal + 2;

		// Baixar temperatura para a desejada.
		while (tempAtual > tempFinal) {
			valorAtual.add(this.baixarTemperatura());
		}

		// Manter a temperatura dentro da margem aceitável pelo tempo
		// determinado.
		for (int t = 0; t < minutos; t++) {
			tempAtual += 0.5;

			// Se a temperatura não estiver abaixo da margem baixar a
			// temperatura.
			if (!(tempAtual < margem)) {
				valorAtual.add(this.baixarTemperatura());
			}
		}

		this.valor.add(valorAtual);

		return valorAtual;
	}

	private BigDecimal baixarTemperatura() {
		BigDecimal resposta = new BigDecimal(0.00);

		if (arCondicionado.isLigado()) {
			resposta.add(new BigDecimal(0.10));
		} else {
			resposta.add(new BigDecimal(0.50));
		}

		arCondicionado.reduz_um_grau();

		this.tempAtual--;

		return resposta;
	}
}

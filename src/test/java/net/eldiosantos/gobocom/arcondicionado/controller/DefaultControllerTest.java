package net.eldiosantos.gobocom.arcondicionado.controller;

import java.math.BigDecimal;

import junit.framework.Assert;
import net.eldiosantos.gobocom.arcondicionado.controller.interfaces.Controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultControllerTest {

	Controller controller;

	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");

		controller = context.getBean("controller", Controller.class);
	}

	// Validar cálculo
	@Test
	public void testCalcularCustoCaso1() {
		float tempIni = 20;
		float tempFim = 18;
		int tempo = 5;

		BigDecimal custo = new BigDecimal("0.70");

		controller.manterTemperatura(tempIni, tempFim, tempo);

		Assert.assertEquals(custo, controller.custoTotal());
	}

	@Test
	public void testCalcularCustoCaso2() {
		float tempIni = 25;
		float tempFim = 20;
		int tempo = 30;

		BigDecimal custo = new BigDecimal("2.30");

		controller.manterTemperatura(tempIni, tempFim, tempo);

		Assert.assertEquals(custo, controller.custoTotal());
	}

}

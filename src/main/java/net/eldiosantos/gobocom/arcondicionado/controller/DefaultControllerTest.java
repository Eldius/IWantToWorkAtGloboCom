package net.eldiosantos.gobocom.arcondicionado.controller;

import java.math.BigDecimal;

import junit.framework.Assert;

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

		controller = context.getBean(Controller.class);
	}

	@Test
	public void test() {
		float tempIni = 20;
		float tempFim = 18;
		int tempo = 5;

		BigDecimal custo = new BigDecimal(70.0);

		controller.manterTemperatura(tempIni, tempFim, tempo);

		Assert.assertEquals(custo, controller.costoTotal());
	}

}

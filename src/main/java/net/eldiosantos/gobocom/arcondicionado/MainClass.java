package net.eldiosantos.gobocom.arcondicionado;

import net.eldiosantos.gobocom.arcondicionado.controller.interfaces.Controller;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Classe principal do projeto.
 * 
 * @author Eldius
 * 
 */
public class MainClass {

	private static Logger logger = Logger.getLogger(MainClass.class);

	/**
	 * Método main.
	 * 
	 * @param args
	 *            temperatura inicial, temperatura final, tempo
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"application-context.xml");

		if ((args.length == 1) && (args[0].equalsIgnoreCase("help"))) {
			System.out
					.println("Parâmetros:\n\ttemperaturaInicial temperaturaFinal tempoEmMinutos");
			System.exit(0);
		}

		if (args.length != 3) {
			System.out
					.println("Número de parâmetros incorreto.\nOa parâmetros são:\n\ttemperaturaInicial temperaturaFinal tempoEmMinutos");
			System.exit(0);
		}

		logger.info("Iniciando programa...");

		Controller controller = context.getBean("controller", Controller.class);

		try {
			float tempIni = Float.valueOf(args[0]);
			float tempFim = Float.valueOf(args[1]);
			int tempo = Integer.valueOf(args[2]);

			controller.manterTemperatura(tempIni, tempFim, tempo);
		} catch (Exception e) {
			logger.error("Parâmetros inválidos.", e);
			System.exit(1);
		}

	}
}

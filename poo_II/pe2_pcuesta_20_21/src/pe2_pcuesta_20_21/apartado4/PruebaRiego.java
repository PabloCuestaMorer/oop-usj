package pe2_pcuesta_20_21.apartado4;

import pe2_pcuesta_20_21.apartado1.HuertoUrbano;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class PruebaRiego {
	public static void regarHuerto(HuertoUrbano huerto, int litrosDeAgua) {
		try {
			huerto.regar(litrosDeAgua);
			System.out.println("Se han utilizado " + litrosDeAgua + " litros para regar el huerto");
		} catch (AguaInsuficienteException e) {
			System.out.println("No me ha llegado el agua... " + litrosDeAgua + " + 100 = " + (litrosDeAgua + 100));
			regarHuerto(huerto, litrosDeAgua + 10);
		}
	}
}

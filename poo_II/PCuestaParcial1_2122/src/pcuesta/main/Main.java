/**
 * 
 */
package pcuesta.main;

import java.util.Arrays;
import java.util.Random;

import pcuesta.pregunta1.Irregular;
import pcuesta.pregunta1.Mercancia;
import pcuesta.pregunta1.Ortoedro;
import pcuesta.pregunta1.Piramide;
import pcuesta.pregunta2.MercanciaHelper;

/**
 * @author pablo
 * @date 2023-03-12
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Mercancia mercancia = new Irregular(2.2f);
		Mercancia mercancia2 = new Irregular(2.2f);
		Mercancia mercancia3 = new Ortoedro(2.2f, 0f, 0f);
		Mercancia mercancia4 = new Piramide(4.4f, 0f, 0f);

		MercanciaHelper helper = new MercanciaHelper();

		Mercancia[] mercancias = helper.createMercanciasRandom(4);
//		Mercancia.printMercancias(mercancias);

//		System.out.println(helper.createMercanciaRandom().toString());
		System.out.println(Arrays.toString(mercancias));
//		System.out.println("Volumen total: " + helper.calculaVolumenTotal(mercancias));
//		System.out.println("MIN volumen: " + helper.buscaMínimoMaximo(mercancias, true));
//		System.out.println("MAX volumen: " + helper.buscaMínimoMaximo(mercancias, false));
//		System.out.println(Arrays.toString(helper.ordenaAscendenteDescendente(mercancias, false)));
//		System.out.println(Arrays.toString(helper.ordenaAscendenteDescendente(mercancias, true)));
		System.out.println(Arrays.toString(helper.deleteMercancia(mercancias, mercancias[2])));
//		System.out.println(Arrays.toString(helper.deleteAboveBelow(mercancias, mercancias[2].getVolumen(), true)));
//		System.out.println(Arrays.toString(helper.deleteAboveBelow(mercancias, mercancias[2].getVolumen(), false)));

	}

}

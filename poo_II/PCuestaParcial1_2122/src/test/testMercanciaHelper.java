/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pcuesta.pregunta1.Mercancia;
import pcuesta.pregunta2.MercanciaHelper;

/**
 * @author pablo
 * @date 2023-03-15
 */
class testMercanciaHelper {

	@Test
	void testVolumenTotal() {
		MercanciaHelper helper = new MercanciaHelper();
		Mercancia[] mercancias = helper.createMercanciasRandom(2);
		float volumenTotal = mercancias[0].getVolumen() + mercancias[1].getVolumen();
		assertEquals(volumenTotal, helper.calculaVolumenTotal(mercancias));
	}

}

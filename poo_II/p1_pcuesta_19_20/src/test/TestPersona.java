/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import beans.Estado;
import beans.Persona;
import beans.Poblacion;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-03-12
 */
class TestPersona {

	@Test
	public void testUnDiaMasMuere() {
		Poblacion poblacion = new Poblacion(1);
		Persona persona = poblacion.getPersonas()[0];
		persona.setVida(0);

		persona.unDiaMas(poblacion);

		assertEquals(Estado.MUERTO, persona.getEstado());
	}

	@Test
	public void testUnDiaMasInfectado() {
		Poblacion poblacion = new Poblacion(1);
		Persona persona = poblacion.getPersonas()[0];
		persona.setVida(20);

		persona.unDiaMas(poblacion);

		assertEquals(Estado.INFECTADO, persona.getEstado());
	}

	@Test
	public void testUnDiaMasCurado() {
		Poblacion poblacion = new Poblacion(1);
		Persona persona = poblacion.getPersonas()[0];
		persona.setVida(40);

		persona.unDiaMas(poblacion);

		assertEquals(Estado.CURADO, persona.getEstado());
	}

}

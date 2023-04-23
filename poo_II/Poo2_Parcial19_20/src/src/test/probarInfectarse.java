package src.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import Antonio.plantas2.Persona;

class probarInfectarse {

	@Test
	void test() {
		Persona infectado = new Persona();
		infectado.enfermarse();
		Persona curado = new Persona();
		
		curado.recibirToses(infectado);
		
		assertEquals(Persona.MUERTO, curado.getState());
	}

}

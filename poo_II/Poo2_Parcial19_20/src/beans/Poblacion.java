package beans;

import java.util.Random;

public class Poblacion {

	private Persona[] poblacion;

	Random rand = new Random(System.currentTimeMillis());

	// 5.1
	public Poblacion(int numPoblacion) {

		poblacion = new Persona[numPoblacion];
		for (int i = 0; i < numPoblacion; i++) {
			poblacion[i] = crearPersona();
		}
	}

	public Persona crearPersona() {

		int random = rand.nextInt(10);

		switch (random) {
		case 0:
			Sanitario p1 = new Sanitario(2);
			p1.enfermarse();
			return p1;
		case 1:
			return new Sanitario(4);
		case 2:
			Hipocondriaco p2 = new Hipocondriaco();
			p2.enfermarse();
			return p2;
		case 3:
		case 4:
			return new Hipocondriaco();
		case 5:
			return new Creyente();
		case 6:
			Persona p3 = new Persona();
			p3.enfermarse();
			return p3;
		default:
			return new Persona();

		}
	}

	// 5.3
	public Persona getPersona() {

		int personaRandom = rand.nextInt(poblacion.length);
		return poblacion[personaRandom];
	}

	// 5.4
	public boolean finDelMundo() {
		for (int i = 0; i < poblacion.length; i++) {
			if (poblacion[i].state != Persona.MUERTO) {
				break;
			}
			if (i == poblacion.length - 1) {
				System.out.println("TODOS ESTAN MUERTOS");
			return true;}
		}
		for (int i = 0; i < poblacion.length; i++) {
			if (poblacion[i].state != Persona.CURADO) {
				break;
			}
			if (i == poblacion.length - 1) {
				System.out.println("TODOS ESTAN CURADOS");
				return true;
			}
		}

		for (int i = 0; i < poblacion.length; i++) {
			if (poblacion[i].state == Persona.INFECTADO) {
				break;
			}
			if (i == poblacion.length - 1) {
				System.out.println("YA NO QUEDAN INFECTADOS");
				return true;
				}
		}
		return false;
	}

	public void mostrarPoblacion() {
		int sanos = 0, infectados = 0, curados = 0, muertos = 0;
		for (int i = 0; i < poblacion.length; i++) {
			if (poblacion[i].state == Persona.SANO) {
				sanos++;
			} else if (poblacion[i].state == Persona.INFECTADO) {
				infectados++;
			} else if (poblacion[i].state == Persona.CURADO) {
				curados++;
			} else if (poblacion[i].state == Persona.MUERTO) {
				muertos++;
			}
		}
		System.out.println("Total: " + poblacion.length + " - Sanos: " + sanos + " - Infectados: " + infectados
				+ " - Curados: " + curados + " - Muertos: " + muertos);
		for (int i = 0; i < poblacion.length; i++) {
			poblacion[i].mostrarPersona();
		}
	}
	
	public Persona[] getPersonas() {
		return poblacion;
	}
}

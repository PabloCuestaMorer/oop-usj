/**
 * 
 */
package beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-03-09
 */
public class Poblacion {
	private Persona[] personas;
	private int numPersonas;
	private int numInfectados;
	private int numCurados;

	public Poblacion() {
	}

	public Poblacion(int numPersonas) {
		this.numPersonas = numPersonas;
		personas = new Persona[numPersonas];
		addPersonas(numPersonas);
	}

	private void addPersonas(int numPersonas) {
		for (int i = 0; i < numPersonas; i++) {
			Random rand = new Random();
			int probabilidad = rand.nextInt(1, 10);
			switch (probabilidad) {
			case 1: {
				personas[i] = new Sanitario(true, generarNumPacientes());
				break;
			}
			case 2: {
				personas[i] = new Sanitario(false, generarNumPacientes());
				break;
			}
			case 3: {
				personas[i] = new Hipocondriaco(true);
				break;
			}
			case 4:
			case 5: {
				personas[i] = new Hipocondriaco(false);
				break;
			}
			case 6: {
				personas[i] = new Creyente();
				break;
			}
			case 7: {
				personas[i] = new Persona(true);
				break;
			}
			default:
				personas[i] = new Persona(false);
			}

			if (personas[i].getEstado() == Estado.INFECTADO) {
				numInfectados++;
			} else {
				numCurados++;
			}
		}
	}

	public ArrayList<Persona> elegirPersonasAleatorias(int numPersonas) {
		ArrayList<Persona> personasSeleccionadas = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < numPersonas; i++) {
			Persona personaSeleccionada = personas[rand.nextInt(numPersonas)];
			if (!personasSeleccionadas.contains(personaSeleccionada)) {
				personasSeleccionadas.add(personaSeleccionada);
			}
		}
		return personasSeleccionadas;
	}

	private int generarNumPacientes() {
		Random rand = new Random();
		return rand.nextInt(3) + 1;
	}

	public Persona getPersonaAleatoria() {
		Random rand = new Random();
		return personas[rand.nextInt(numPersonas)];
	}

	/**
	 * Método que indica si el mundo ha acabado ya, el mundo se acaba cuando todas
	 * las personas están muertas o todas las personas están curadas o ya no queda
	 * ningún infectado.
	 * 
	 * @return boolean
	 */
	public boolean mundoHaAcabado() {
		return numPersonas == numPersonas - (numCurados + numInfectados) || numCurados == numPersonas
				|| numInfectados == 0;
	}

	public void actualizarEstado(int indice, Estado estadoAnterior, Estado estadoNuevo) {
		if (estadoAnterior == Estado.INFECTADO && estadoNuevo == Estado.CURADO) {
			numInfectados--;
			numCurados++;
		} else if (estadoAnterior != Estado.CURADO && estadoNuevo == Estado.INFECTADO) {
			numInfectados++;
		}
		personas[indice].setEstado(estadoNuevo);
	}

	/**
	 * @return the personas
	 */
	public Persona[] getPersonas() {
		return personas;
	}

	/**
	 * @param personas the personas to set
	 */
	public void setPersonas(Persona[] personas) {
		this.personas = personas;
	}

	/**
	 * @return the numPersonas
	 */
	public int getNumPersonas() {
		return numPersonas;
	}

	/**
	 * @param numPersonas the numPersonas to set
	 */
	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
	}

	@Override
	public String toString() {
		return "Poblacion [personas=" + Arrays.toString(personas) + "]";
	}

}

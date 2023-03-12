/**
 * 
 */
package beans;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-03-09
 */
// La clase Sanitario, es similar a la clase Persona
public class Sanitario extends Persona {
	// 2.1. tiene un parámetro extra que indica el numero de pacientes capaz de
	// atender en un día (valor aleatorio entre 1 y 3 que es recibido por el
	// constructor).
	private int contactosDiarios;
	private int pacientesAtendidos;

	public Sanitario(int pacientesAtendidos) {
		super();
		// 2.1. tiene un parámetro extra que indica el numero de pacientes capaz de
		// atender en un día (valor aleatorio entre 1 y 3 que es recibido por el
		// constructor).
		this.contactosDiarios = new Random().nextInt(4);
		this.pacientesAtendidos = pacientesAtendidos;
	}

	public Sanitario(boolean infectado, int pacientesAtendidos) {
		super(infectado);
		this.contactosDiarios = new Random().nextInt(4);
		this.pacientesAtendidos = pacientesAtendidos;
	}

	@Override
	public void unDiaMas(Poblacion poblacion) {
		if (estado != Estado.MUERTO) {
			// 2.2. además de toser y sufrir la enfermedad (como cualquier persona),
			toser(poblacion);
			sufrirEnfermedad();
			// 2.2. ...administrará curas
			// 2.2. ...a un número de personas, elegidas de forma
			// aleatoria entre la población, igual a su número de pacientes.
			ArrayList<Persona> pacientes = poblacion.elegirPersonasAleatorias(this.pacientesAtendidos);
			for (Persona paciente : pacientes) {
				if (paciente.getEstado() == Estado.INFECTADO) {
					// 2.2. ...Para ello todas las personas deben estar preparadas para recibir
					// dichas curas
					// (aumentando su salud en una cantidad aleatoria entre 0 y 20).
					int vidas = new Random().nextInt(21);
					paciente.aumentarVida(vidas);
					// 2.2. ... Además, si estaban infectados y su vida tras la recibir la cura es
					// superior a
					// 120 se volverán inmunes al coronavirus pasando al estado Curado.
					if (paciente.getVida() > 120) {
						paciente.setEstado(Estado.CURADO);
					}
				}
			}
		}

	}
}
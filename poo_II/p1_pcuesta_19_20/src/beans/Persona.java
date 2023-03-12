/**
 * 
 */
package beans;

import java.util.Random;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-03-09
 */

public class Persona {
	// 1.1. Un atributo indicará la vida de la persona (se inicializa a un valor
	// aleatorio entre 80 y 100)
	private int vida;
	// 1.2. Un atributo indicará el número de contactos diarios (se inicializa a un
	// valor aleatorio entre 0 y 3
	private int contactosDiarios;
	// 1.3. Un atributo indicará el estado actual de la persona, que puede ser:
	// Sano, Infectado, Curado o Muerto.
	protected Estado estado;

	protected Random rand = new Random();;

	// 1.4. Un constructor por defecto y un constructor que recibe un parámetro de
	// entrada que indica si la persona está infectada. Encadena de forma adecuada
	// los constructores
	public Persona() {
		this.vida = rand.nextInt(80, 100);
		this.contactosDiarios = rand.nextInt(4);
		this.estado = Estado.SANO;
	}

	// 1.4. Un constructor por defecto y un constructor que recibe un parámetro de
	// entrada que indica si la persona está infectada. Encadena de forma adecuada
	// los constructores.
	public Persona(boolean infectado) {
		this();
		if (infectado) {
			this.estado = Estado.INFECTADO;
		}
	}

	/**
	 * asñdfañsdflkajsñd
	 * @param poblacion
	 */
	// 1.5. Un método unDiaMas, que recibe un objeto de tipo Población y que se
	// encarga de simular el día de dicha persona.
	public void unDiaMas(Poblacion poblacion) {
		// Mientras no este muerto la persona hace dos cosas en el día:
		if (estado != Estado.MUERTO) {
			// 1.5.1. toser
			toser(poblacion);
			if (estado == Estado.INFECTADO) {
				// 1.5.2. sufrir la enfermedad, de manera que si esta infectado pierde una
				// cantidad aleatoria (0-10) de vida.
				sufrirEnfermedad();
				if (vida <= 0) {
					estado = Estado.MUERTO;
				} else if (vida > 0 && vida < 30) {
					estado = Estado.INFECTADO;
				} else if (vida >= 30) {
					estado = Estado.CURADO;
				}
			}
		}
	}

	// 1.5.1. toser, un numero de personas elegidas al azar entre toda la población
	// igual a su numero de contactos diarios “recibirán sus toses”.
	protected void toser(Poblacion poblacion) {
		for (int i = 0; i < contactosDiarios; i++) {
			Persona persona = poblacion.getPersonaAleatoria();
			if (persona.estado == Estado.SANO) {
				// 1.6. Un método recibirToses,
				persona.recibirToses(this);
			}
		}
	}

	// 1.6. Un método recibirToses, donde se determina que le pasa a una persona
	// cuando le tosen, pueden pasar dos cosas, si el tosedor esta infectado, la
	// persona tosida se infecta (en caso de que aun no este infectada). Si el
	// tosedor esta curado, la persona tosida pasa a estar curada (en caso de que
	// estuviese infectada). Las toses no afectan a la gente muerta o a la gente
	// curada.
	public void recibirToses(Persona tosedor) {
		if (tosedor.estado == Estado.INFECTADO) {
			estado = Estado.INFECTADO;
		} else if (tosedor.estado == Estado.CURADO) {
			estado = Estado.CURADO;
		}
	}

	// 1.5.2. sufrir la enfermedad, de manera que si esta infectado pierde una
	// cantidad aleatoria (0-10) de vida.
	protected void sufrirEnfermedad() {
		vida -= rand.nextInt(11);
	}

	/**
	 * Increases the person's life by the given amount, up to a maximum of 120.
	 * 
	 * @param cantidad The amount to increase the person's life by.
	 */
	public void aumentarVida(int vidas) {
		this.vida = Math.min(this.vida + vidas, 120);
	}

// Getters/Setters -------------------------------------------------------------------------------------------------------

	/**
	 * @return the vida
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * @param vida the vida to set
	 */
	public void setVida(int vida) {
		this.vida = vida;
	}

	/**
	 * @return the contactosDiarios
	 */
	public int getContactosDiarios() {
		return contactosDiarios;
	}

	/**
	 * @param contactosDiarios the contactosDiarios to set
	 */
	public void setContactosDiarios(int contactosDiarios) {
		this.contactosDiarios = contactosDiarios;
	}

	/**
	 * @return the estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}

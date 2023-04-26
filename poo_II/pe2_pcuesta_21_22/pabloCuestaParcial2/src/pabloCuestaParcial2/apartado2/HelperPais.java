package pabloCuestaParcial2.apartado2;

import java.util.Random;
import java.util.Set;

import pabloCuestaParcial2.apartado1.Persona;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class HelperPais {

	/**
	 * 
	 * Crea una nueva instancia de la clase Persona utilizando elementos aleatorios
	 * de dos conjuntos de cadenas de caracteres (nombres y apellidos) y un número
	 * aleatorio que representa la edad.
	 * 
	 * @param nombres
	 * @param apellidos
	 * @return una nueva instancia de Persona con datos
	 * @throws IllegalArgumentException si uno o ambos conjuntos están vacíos
	 */
	public static Persona createPersona(Set<String> nombres, Set<String> apellidos) {
		if (nombres.isEmpty() || apellidos.isEmpty()) {
			throw new IllegalArgumentException("Los sets de nombres y apellidos no deben estar vacíos.");
		}

		String nombre = obtenerElementoAleatorio(nombres);
		String apellido1 = obtenerElementoAleatorio(apellidos);
		String apellido2 = obtenerElementoAleatorio(apellidos);
		int edad = new Random().nextInt(1, 101);

		return new Persona(nombre, apellido1, apellido2, edad);
	}

	/**
	 * 
	 * Devuelve un elemento aleatorio de un conjunto de cadenas de caracteres.
	 * 
	 * @param Set<String> elementos del que se extraerá un elemento aleatorio
	 * @return String un elemento aleatorio
	 */
	private static String obtenerElementoAleatorio(Set<String> elementos) {
		int indice = new Random().nextInt(elementos.size());
		String[] elementosArray = elementos.toArray(new String[0]);

		for (int i = 0; i < elementosArray.length; i++) {
			if (i == indice) {
				return elementosArray[i];
			}
		}
		return null;
	}
}

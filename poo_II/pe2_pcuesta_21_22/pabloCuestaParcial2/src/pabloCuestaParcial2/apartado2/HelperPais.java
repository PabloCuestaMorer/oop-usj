package pabloCuestaParcial2.apartado2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import pabloCuestaParcial2.apartado1.Pais;
import pabloCuestaParcial2.apartado1.Persona;
import pabloCuestaParcial2.apartado1.Provincia;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class HelperPais {

	/**
	 * 2.1 Crea una nueva instancia de la clase Persona utilizando elementos
	 * aleatorios de dos conjuntos de cadenas de caracteres (nombres y apellidos) y
	 * un número aleatorio que representa la edad.
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

	/**
	 * 2.2 Crea una nueva instancia de la clase Pais con un nombre y un número
	 * especificado de provincias, cada una con un nombre aleatorio y un número
	 * aleatorio de personas con nombres y apellidos aleatorios generados a partir
	 * de dos conjuntos dados. El número de personas por provincia se encuentra
	 * dentro de un rango especificado.
	 * 
	 * @param nombrePais    el nombre del país
	 * @param numProvincias el número de provincias que tendrá el país
	 * @param maxPersonas   el número máximo de personas por provincia
	 * @param minPersonas   el número mínimo de personas por provincia
	 * @param nombres       el conjunto de nombres del que se extraerán los nombres
	 *                      aleatorios para las personas
	 * @param apellidos     el conjunto de apellidos del que se extraerán los
	 *                      apellidos aleatorios para las personas
	 * @return una nueva instancia de la clase Pais con provincias y personas
	 *         aleatorias
	 * @throws IllegalArgumentException si uno o ambos conjuntos de nombres y
	 *                                  apellidos están vacíos, si el rango de
	 *                                  personas por provincia no es válido o si el
	 *                                  número de provincias es menor o igual a 0
	 */
	public static Pais createPais(String nombrePais, int numProvincias, int maxPersonas, int minPersonas,
			Set<String> nombres, Set<String> apellidos) {
		// Comprobar parametros
		if (nombres.isEmpty() || apellidos.isEmpty()) {
			throw new IllegalArgumentException("Los sets de nombres y apellidos no deben estar vacíos.");
		}
		if (minPersonas > maxPersonas) {
			throw new IllegalArgumentException("El rango de personas por provincia no es válido.");
		}
		if (numProvincias <= 0) {
			throw new IllegalArgumentException("El número de provincias debe ser mayor que 0.");
		}

		Random random = new Random();
		Pais pais = new Pais(nombrePais);
		for (int i = 0; i < numProvincias; i++) {
			String nombreProvincia = ProvinciasEspana.values()[random.nextInt(ProvinciasEspana.values().length)]
					.toString();
			Provincia provincia = new Provincia(nombreProvincia);

			int numPersonas = random.nextInt(minPersonas, maxPersonas + 1);
			for (int j = 0; j < numPersonas; j++) {
				Persona persona = createPersona(nombres, apellidos);
				provincia.agregarPersona(persona);
			}
			pais.agregarProvincia(provincia);
		}

		return pais;
	}

	/**
	 * 
	 * 2.3 Busca todas las personas en un país que coinciden con un nombre y
	 * apellidos específicos y devuelve una lista de objetos de la clase Persona. Si
	 * no se encuentra ninguna persona, lanza una excepción PersonaNotFound.
	 * 
	 * @param pais      el país en el que se realizará la búsqueda de personas
	 * @param nombre    el nombre de la persona que se está buscando
	 * @param apellido1 el primer apellido de la persona que se está buscando
	 * @param apellido2 el segundo apellido de la persona que se está buscando
	 * @return una lista de objetos de la clase Persona que coinciden con el nombre
	 *         y apellidos proporcionados
	 * @throws PersonaNotFound si no se encuentra ninguna persona con el nombre y
	 *                         apellidos proporcionados
	 */
	public static List<Persona> buscaPersonas(Pais pais, String nombre, String apellido1, String apellido2)
			throws PersonaNotFound {
		List<Persona> personasEncontradas = new ArrayList<>();

		for (Provincia provincia : pais.getProvincias()) {
			for (Persona persona : provincia.getPersonas()) {
				if (persona.getNombre().equals(nombre) && persona.getApellido1().equals(apellido1)
						&& persona.getApellido2().equals(apellido2)) {
					personasEncontradas.add(persona);
				}
			}
		}

		if (personasEncontradas.isEmpty()) {
			throw new PersonaNotFound("No se encontró ninguna persona con el nombre: {" + nombre + "} y apellidos: {"
					+ apellido1 + " " + apellido2 + "} proporcionados.");
		} else {
			System.out.println("Se han encontrado " + personasEncontradas.size()
					+ " personas con el nombre y apellidos \"" + nombre + " " + apellido1 + " " + apellido2 + "\".");
		}

		return personasEncontradas;
	}

}

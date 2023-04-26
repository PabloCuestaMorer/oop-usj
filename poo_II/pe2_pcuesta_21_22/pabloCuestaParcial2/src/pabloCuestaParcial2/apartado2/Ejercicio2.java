package pabloCuestaParcial2.apartado2;

import java.util.Set;

import pabloCuestaParcial2.apartado1.Pais;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Ejercicio2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> nombres = Set.of("Pepe", "Juan", "Marcos", "Lucia", "Maria");
		Set<String> apellidos = Set.of("Gomez", "Perez", "Sanchez", "Garcia", "Lopez");

		Pais espana = HelperPais.createPais("España", 10, 20, 5, nombres, apellidos);
		System.out.println(espana.toString());

		// Busca una persona que exista e imprime cuantas personas has encontrado con
		// ese nombre y apellidos.
		try {
			HelperPais.buscaPersonas(espana, "Pepe", "Gomez", "Perez");
		} catch (PersonaNotFound e) {
			System.out.println(e.getMessage());
		}

		// Busca una que no exista, captura la excepción e imprime un mensaje por
		// pantalla.
		try {
			HelperPais.buscaPersonas(espana, "NombreInexistente", "ApellidoInexistente", "ApellidoInexistente");
		} catch (PersonaNotFound e) {
			System.out.println(e.getMessage());
		}
	}

}

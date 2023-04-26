package pabloCuestaParcial2.apartado4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import pabloCuestaParcial2.apartado3.Indice;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Ejercicio4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Generar extensiones
		String[] extensiones = Indice.generarExtensiones(5);

		// Crear carpeta para guardar archivos
		Path carpeta = Paths.get("prueba_ejercicio4");
		int numArchivos = 30;
		double probabilidadCarpeta = 0.3;

		// Generar archivos y carpetas recursivamente
		Indice.generarArchivosRecursivo(carpeta, numArchivos, extensiones, probabilidadCarpeta);

		// Generar índice de archivos por extensión
		Map<String, Integer> indice = new HashMap<>();
		try {
			Indice.generarIndiceRecursivo(carpeta, indice);
			System.out.println("Índice de archivos por extensión:");
			for (Map.Entry<String, Integer> entry : indice.entrySet()) {
				System.out.println(entry.getKey() + ": " + entry.getValue());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

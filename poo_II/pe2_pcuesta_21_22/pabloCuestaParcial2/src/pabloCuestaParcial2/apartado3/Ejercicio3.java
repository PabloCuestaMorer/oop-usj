package pabloCuestaParcial2.apartado3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * 3.4. Crea una clase Ejercicio3 con un método main y comprueba que los métodos
 * anteriores funcionan creando un array de 1000 extensiones, generando 5000
 * archivos en una carpeta llamada p3 dentro del proyecto (que funcione cuando
 * lo pruebe en mi ordenador), generando el índice e imprimiéndolo por pantalla
 * de forma legible.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Ejercicio3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Crear un array de 1000 extensiones
		String[] extensiones = Indice.generarExtensiones(1000);

		// Crear 5000 archivos en una carpeta llamada p3
		Path carpeta = Paths.get("p3");
//		Indice.generarArchivos(carpeta, 5000, extensiones);
		Indice.generarArchivos(carpeta, 50, extensiones);

		// Generar el índice
		Map<String, Integer> indice = Indice.generarIndice(carpeta);

		// Imprimir el índice de forma legible
		System.out.println("Índice de archivos por extensión:");
		for (Map.Entry<String, Integer> entry : indice.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}

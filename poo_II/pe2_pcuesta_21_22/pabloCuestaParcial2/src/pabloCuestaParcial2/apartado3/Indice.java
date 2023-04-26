package pabloCuestaParcial2.apartado3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * 
 * Crea una clase Indice que tenga una serie de métodos estáticos:
 * 
 * 3.1. generarExtensiones que reciba como parámetro de entrada un número de
 * extensiones a crear y devuelva un array de Strings ([] un array “clásico”, no
 * una colección) que contenga extensiones aleatorias. Las extensiones se crean
 * uniendo un punto y tres letras aleatorias, pero debes garantizar que no hay
 * duplicados en el array de extensiones devuelto.
 * 
 * 3.2. generarArchivos que reciba como parámetro de entrada un Path (no un
 * String) a una carpeta, un número de archivos y un array de extensiones. La
 * función generará el número de archivos pedido (archivos vacíos) en la carpeta
 * indicada. Cada archivo tendrá como nombre un numero consecutivo (para evitar
 * colisiones) y una extensión elegida de forma aleatoria de entre las recibidas
 * como parámetro. Asegúrate de que la carpeta existe antes de crear los
 * archivos y si no existe créala tu.
 * 
 * 3.3. generarIndice que reciba como parámetro de entrada un Path a una carpeta
 * y devuelva un Map<String, Integer>. La función debe recorrer la carpeta dada
 * e ir generando un índice que indique el número de archivos que existen en la
 * carpeta para cada extensión.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Indice {

	/**
	 * Genera un array de cadenas de caracteres que representan extensiones de
	 * archivo únicas y aleatorias. El número de extensiones generado está
	 * determinado por el parámetro numExtensiones. Cada extensión tiene la forma
	 * ".xxx", donde "xxx" son tres letras minúsculas aleatorias.
	 *
	 * @param numExtensiones el número de extensiones de archivo que se desean
	 *                       generar
	 * @return un array de cadenas de caracteres que representan extensiones de
	 *         archivo únicas y aleatorias
	 * @throws IllegalArgumentException si numExtensiones es menor o igual a 0
	 */

	public static String[] generarExtensiones(int numExtensiones) {
		if (numExtensiones <= 0) {
			throw new IllegalArgumentException("El número de extensiones debe ser mayor que 0.");
		}

		Set<String> extensionesSet = new HashSet<>();
		Random rand = new Random();

		while (extensionesSet.size() < numExtensiones) {
			StringBuilder extension = new StringBuilder();
			extension.append('.');
			for (int i = 0; i < 3; i++) {
				extension.append((char) (rand.nextInt(26) + 'a'));
			}
			extensionesSet.add(extension.toString());
		}

		return extensionesSet.toArray(new String[numExtensiones]);
	}

	/**
	 * Genera un número especificado de archivos con extensiones aleatorias en una
	 * carpeta especificada. Las extensiones de archivo se seleccionan de un array
	 * de cadenas de caracteres proporcionado. Si la carpeta no existe, se crea.
	 *
	 * @param carpeta     la carpeta en la que se crearán los archivos
	 * @param numArchivos el número de archivos que se generarán
	 * @param extensiones un array de cadenas de caracteres que representan las
	 *                    extensiones de archivo que se seleccionarán aleatoriamente
	 * @throws IllegalArgumentException si carpeta no es una carpeta válida, si
	 *                                  numArchivos es menor o igual a 0 o si
	 *                                  extensiones es null o vacío
	 * @throws RuntimeException         si no se puede crear la carpeta o el archivo
	 */

	public static void generarArchivos(Path carpeta, int numArchivos, String[] extensiones) {
		if (!Files.exists(carpeta)) {
			try {
				Files.createDirectories(carpeta);
			} catch (IOException e) {
				throw new RuntimeException("No se pudo crear la carpeta: " + carpeta, e);
			}
		}

		if (!Files.isDirectory(carpeta)) {
			throw new IllegalArgumentException("El Path proporcionado no es una carpeta.");
		}

		Random rand = new Random();

		for (int i = 1; i <= numArchivos; i++) {
			String extension = extensiones[rand.nextInt(extensiones.length)];
			Path archivo = carpeta.resolve(i + extension);

			try {
				Files.createFile(archivo);
			} catch (IOException e) {
				throw new RuntimeException("No se pudo crear el archivo: " + archivo, e);
			}
		}
	}

	/**
	 * Genera un índice de las extensiones de archivo en una carpeta especificada y
	 * cuenta cuántas veces aparece cada extensión. El índice es un mapa que asocia
	 * una cadena de caracteres que representa una extensión de archivo con un
	 * número entero que indica cuántas veces aparece esa extensión en la carpeta.
	 *
	 * @param carpeta la carpeta para la que se generará el índice de extensiones de
	 *                archivo
	 * @return un mapa que asocia las extensiones de archivo con el número de
	 *         archivos que tienen esa extensión
	 * @throws IllegalArgumentException si carpeta no es una carpeta válida
	 * @throws RuntimeException         si no se puede leer la carpeta
	 */

	public static Map<String, Integer> generarIndice(Path carpeta) {
		if (!Files.exists(carpeta) || !Files.isDirectory(carpeta)) {
			throw new IllegalArgumentException("El Path proporcionado no existe o no es una carpeta.");
		}

		Map<String, Integer> indice = new HashMap<>();

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(carpeta)) {
			for (Path archivo : stream) {
				if (Files.isRegularFile(archivo)) {
					String extension = obtenerExtension(archivo);
					// valor clave actual: si no existe es 0 / si encuentra le suma 1
					indice.put(extension, indice.getOrDefault(extension, 0) + 1);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("No se pudo leer la carpeta: " + carpeta, e);
		}

		return indice;
	}

	/**
	 * Obtiene la extensión de archivo de un Path especificado. La extensión es la
	 * parte de la cadena de caracteres que sigue al último punto en el nombre de
	 * archivo.
	 *
	 * @param archivo el archivo del que se va a obtener la extensión
	 * @return una cadena de caracteres que representa la extensión del archivo, o
	 *         una cadena vacía si no se encuentra ninguna extensión
	 */

	private static String obtenerExtension(Path archivo) {
		String nombreArchivo = archivo.getFileName().toString();
		int puntoIndice = nombreArchivo.lastIndexOf('.');

		if (puntoIndice >= 0) {
			return nombreArchivo.substring(puntoIndice);
		} else {
			return "";
		}
	}
}

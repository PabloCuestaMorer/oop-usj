/**
 * 
 */
package pe2_pcuesta_20_21.apartado3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pe2_pcuesta_20_21.apartado1.Cultivo;
import pe2_pcuesta_20_21.apartado1.HuertoUrbano;
import pe2_pcuesta_20_21.apartado1.Parcela;

/**
 * 3.1. un método estático toFile que reciba un HuertoUrbano y un nombre de
 * fichero y sea capaz de persistir el HuertoUrbano a un fichero que pueda ser
 * entendido por un humano (No puedes usar un ObjectStream).
 * 
 * 3.2. un método estático fromFile que reciba un nombre de fichero (escrito con
 * el método anterior) y sea capaz de leerlo y crear un objeto de tipo
 * HuertoUrbano con la información contenida en el fichero.
 * 
 * 3.3. un método estático toJerarquia que reciba como parámetro un HuertoUrbano
 * y genere una serie de ficheros y carpetas: como raíz una carpeta llamada
 * huerto_XX (donde XX es el numero de metros del huerto). Dentro de la carpeta
 * huerto, debes crear una carpeta por cada parcela donde el nombre sea
 * parcela_XX (donde XX corresponde al id del cliente a cargo de la parcela).
 * Dentro de la carpeta parcela debes crear un archivo (vacío) por cada planta
 * de cada cultivo con nombres consecutivos (Cebolla1,Cebolla2,Cebolla3,…).
 * 
 * 3.4. un método main desde el que se pruebe el correcto funcionamiento de las
 * funciones anteriores.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class Persistencia {

	/**
	 * 3.1. un método estático toFile que reciba un HuertoUrbano y un nombre de
	 * fichero y sea capaz de persistir el HuertoUrbano a un fichero que pueda ser
	 * entendido por un humano (No puedes usar un ObjectStream).
	 * 
	 * @param huerto
	 * @param nombreArchivo
	 */
	public static void toFile(HuertoUrbano huerto, String nombreArchivo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String huertoJson = gson.toJson(huerto);

		try (PrintWriter writer = new PrintWriter(nombreArchivo)) {
			writer.print(huertoJson);
		} catch (FileNotFoundException e) {
			System.out.println("Error al guardar el archivo: " + e.getMessage());
		}
	}

	/**
	 * 3.2. un método estático fromFile que reciba un nombre de fichero (escrito con
	 * el método anterior) y sea capaz de leerlo y crear un objeto de tipo
	 * HuertoUrbano con la información contenida en el fichero.
	 * 
	 * @param nombreArchivo
	 * @return
	 */
	public static HuertoUrbano fromFile(String nombreArchivo) {
		try (Reader reader = new FileReader(nombreArchivo)) {
			Gson gson = new Gson();
			return gson.fromJson(reader, HuertoUrbano.class);
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo: " + e.getMessage());
			return null;
		} catch (IOException e) {
			System.out.println("Error al cerrar el archivo: " + e.getMessage());
			return null;
		}
	}

	/**
	 * 3.3 Este método crea una jerarquía de sistema de archivos basada en el objeto
	 * de huerto urbano dado. Crea un directorio llamado según el tamaño del huerto,
	 * y para cada parcela de tierra, crea un directorio llamado según el ID del
	 * cliente. Dentro de cada directorio de parcela, crea archivos nombrados según
	 * el nombre del cultivo, seguido de un número que indica el índice de la planta
	 * en el cultivo.
	 * 
	 * @param huerto el objeto de huerto urbano del cual se construira la jerarquía
	 */
	public static void toJerarquia(HuertoUrbano huerto) {
		// Crea un directorio huerto_ + numero de metros del huerto
		String huertoPath = "huerto_" + (int) huerto.getTamaño();
		File huertoDir = new File(huertoPath);
		huertoDir.mkdir();

		// Por cada parcela, parcela_ + id del cliente a cargo de la parcela
		for (Parcela parcela : huerto.getParcelas()) {
			String parcelaPath = huertoPath + "/parcela_" + parcela.getCliente().getIdCliente();
			File parcelaDir = new File(parcelaPath);
			parcelaDir.mkdir();
			// Para cada cultivo en la parcela, crea archivos nombrados según el nombre del
			// cultivo y el índice de la planta
			for (Cultivo cultivo : parcela.getCultivos()) {
				for (int i = 0; i < cultivo.getCantidadDePlantas(); i++) {
					String plantaPath = parcelaPath + "/" + cultivo.getNombre() + (i + 1);
					try {
						Files.createFile(Paths.get(plantaPath));
					} catch (IOException e) {
						System.out.println("Error al crear el archivo: " + plantaPath + " - " + e.getMessage());
					}
				}
			}
		}
	}
}

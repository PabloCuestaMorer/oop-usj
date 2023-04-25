package pe2_pcuesta_20_21.main;

import java.util.HashSet;
import java.util.Set;

import pe2_pcuesta_20_21.apartado1.HuertoUrbano;
import pe2_pcuesta_20_21.apartado2.HelperHuerto;
import pe2_pcuesta_20_21.apartado4.AguaInsuficienteException;
import pe2_pcuesta_20_21.apartado4.PruebaRiego;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		/*
//		 * 2. ...Comprueba que funciona creando un huerto (5000 metros, 22 parcelas y un
//		 * set de nombres de plantas con “Tomate”, “Cebolla”, “Lechuga”, “Zanahoria” y
//		 * “Albahaca”) e imprimiéndolo por pantalla.
//		 */
		Set<String> nombresDePlantas = new HashSet<>();
		nombresDePlantas.add("Tomate");
		nombresDePlantas.add("Cebolla");
		nombresDePlantas.add("Lechuga");
		nombresDePlantas.add("Zanahoria");
		nombresDePlantas.add("Albahaca");

		HuertoUrbano huerto = HelperHuerto.createHuerto(5000, 22, nombresDePlantas);
//		System.out.println(huerto);

		// 3
		// 3.4. un método main desde el que se pruebe el correcto funcionamiento de las
		// funciones anteriores.

		// 3.1 Guardar el objeto huerto en un archivo JSON
//		Persistencia.toFile(huerto, "huerto_urbano.json");

		// 3.2 Leer el archivo JSON y crear un objeto HuertoUrbano a partir de su
		// contenido
//		HuertoUrbano huertoLeido = Persistencia.fromFile("huerto_urbano.json");
//		System.out.println("Huerto leído desde archivo JSON:");
//		System.out.println(huertoLeido);

		// 3.3 Crear la jerarquía de directorios y archivos
//		Persistencia.toJerarquia(huerto);

//		try {
//			huerto.regar(6000); // Ajusta la cantidad de agua según sea necesario
//		} catch (AguaInsuficienteException e) {
//			System.out.println("Error al regar el huerto: " + e.getMessage());
//		}

//		PruebaRiego.regarHuerto(huerto, 1000);

		/*
		 * 4.3. Crea una función main, crea un huerto (con el método de la pregunta 2) y
		 * llama a la función regarHuerto pasando el huerto y 10 litros de agua como
		 * parámetro.
		 */
//		PruebaRiego.regarHuerto(huerto, 10);

	}

}

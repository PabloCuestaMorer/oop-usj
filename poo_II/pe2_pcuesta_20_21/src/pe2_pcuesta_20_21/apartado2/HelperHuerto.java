package pe2_pcuesta_20_21.apartado2;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Set;

import pe2_pcuesta_20_21.apartado1.Cliente;
import pe2_pcuesta_20_21.apartado1.Cultivo;
import pe2_pcuesta_20_21.apartado1.HuertoUrbano;
import pe2_pcuesta_20_21.apartado1.Parcela;

/**
 * 2. Comprueba que las clases anteriores funcionan, creando una clase
 * HelperHuerto que contenga una función estática createHuerto que sea capaz de
 * crear y poblar un objeto de tipo HuertoUrbano.
 * 
 * La función debe recibir como parámetro de entrada el tamaño del huerto, el
 * número de parcelas y un Set con nombres de plantas. Todas las parcelas serán
 * del mismo tamaño, y todas las parcelas contendrán un cultivo cuyo nombre sea
 * cada uno de los nombres del set. El resto de los valores se generan de forma
 * aleatoria.
 * 
 * Comprueba que funciona creando un huerto (5000 metros, 22 parcelas y un set
 * de nombres de plantas con “Tomate”, “Cebolla”, “Lechuga”, “Zanahoria” y
 * “Albahaca”) e imprimiéndolo por pantalla.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class HelperHuerto {

	public static HuertoUrbano createHuerto(double dimensionHuerto, int numParcelas, Set<String> nombresDePlantas) {
		HuertoUrbano huerto = new HuertoUrbano(dimensionHuerto);
		double dimensionParcela = dimensionHuerto / numParcelas;
		DecimalFormat df = new DecimalFormat("#.##");
		dimensionParcela = Double.parseDouble(df.format(dimensionParcela));
		Random random = new Random();

		for (int i = 0; i < numParcelas; i++) {
			String nombreCliente = "Cliente" + (i + 1);
			String apellidoCliente = "Apellido" + (i + 1);
			String telefonoCliente = generarTelefonoAleatorio();
			Cliente cliente = new Cliente(nombreCliente, apellidoCliente, telefonoCliente);
			Parcela parcela = new Parcela(dimensionParcela, cliente);

			for (String nombreDePlanta : nombresDePlantas) {
				String necesidadesDeAgua = NECESIDADES_AGUA.values()[random.nextInt(NECESIDADES_AGUA.values().length)]
						.toString();
				int cantidadDePlantas = random.nextInt(16) + 1;
				Cultivo cultivo = new Cultivo(nombreDePlanta, necesidadesDeAgua, cantidadDePlantas);
				parcela.agregarCultivo(cultivo);
			}

			huerto.agregarParcela(parcela);
		}

		return huerto;
	}

	private static String generarTelefonoAleatorio() {
		Random random = new Random();
		StringBuilder telefono = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			telefono.append(random.nextInt(10));
		}
		return telefono.toString();
	}
}

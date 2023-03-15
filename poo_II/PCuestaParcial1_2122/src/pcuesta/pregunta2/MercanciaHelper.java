package pcuesta.pregunta2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import pcuesta.pregunta1.Cilindro;
import pcuesta.pregunta1.Esfera;
import pcuesta.pregunta1.Irregular;
import pcuesta.pregunta1.Mercancia;
import pcuesta.pregunta1.Ortoedro;
import pcuesta.pregunta1.Piramide;

/**
 * @author pablo
 * @date 2023-03-12
 */
public class MercanciaHelper {

	private final float MIN_PROB = 5.0f;
	private final float MAX_PROB = 10.0f;
	private Random random = new Random();

	/**
	 * Devuelve una mercancía (elige el tipo al azar de entre los 5 posibles)
	 * generada con valores aleatorios (todos floats random entre 5.0 y 10.0).
	 * 
	 * @return
	 */
	public Mercancia createMercanciaRandom() {
		Mercancia mercancia = null;
		int probabilidad = random.nextInt(5);
		switch (probabilidad) {
		case 0: {
			mercancia = new Irregular(random.nextFloat(MIN_PROB, MAX_PROB));
			break;
		}
		case 1: {
			mercancia = new Ortoedro(random.nextFloat(MIN_PROB, MAX_PROB), random.nextFloat(MIN_PROB, MAX_PROB),
					random.nextFloat(MIN_PROB, MAX_PROB));
			break;
		}
		case 2: {
			mercancia = new Piramide(random.nextFloat(MIN_PROB, MAX_PROB), random.nextFloat(MIN_PROB, MAX_PROB),
					random.nextFloat(MIN_PROB, MAX_PROB));
			break;
		}
		case 3: {
			mercancia = new Cilindro(random.nextFloat(MIN_PROB, MAX_PROB), random.nextFloat(MIN_PROB, MAX_PROB));
			break;
		}
		case 4: {
			mercancia = new Esfera(random.nextFloat(MIN_PROB, MAX_PROB));
			break;
		}
		default:
			System.err.println("CACA");
		}
		return mercancia;
	}

	/**
	 * Devuelve un array que contiene la cantidad de mercancías indicada generadas
	 * de forma aleatoria (con el método del ejercicio anterior).
	 * 
	 * @param cantidad
	 * @return
	 */
	public Mercancia[] createMercanciasRandom(int cantidad) {
		Mercancia[] mercancias = new Mercancia[cantidad];
		for (int i = 0; i < mercancias.length; i++) {
			mercancias[i] = createMercanciaRandom();
		}
		return mercancias;
	}

	/**
	 * Devuelve un float que indica el valor total de la suma de los volúmenes de
	 * todas las mercancías pasadas como parámetro.
	 * 
	 * @param mercancias
	 * @return
	 */
	public float calculaVolumenTotal(Mercancia[] mercancias) {
		float out = 0f;
		for (Mercancia mercancia : mercancias) {
			out += mercancia.calcularVolumen();
		}
		return out;
	}

	/**
	 * Devuelve la Mercancia con el valor de volumen más pequeño o más grande (de
	 * entre las proporcionadas como parámetro). El boolean determina si debe
	 * buscarse el mayor o el menor.
	 * 
	 * @param mercancias
	 * @param minimo
	 * @return
	 */
	public Mercancia buscaMínimoMaximo(Mercancia[] mercancias, boolean minimo) {
		Arrays.sort(mercancias);
		if (minimo) {
			return mercancias[0];
		} else {
			return mercancias[mercancias.length - 1];
		}
	}

	/**
	 * Devuelve un array de mercancías ordenado de menor a mayor (o de mayor a
	 * menor) en función de su volumen. El boolean indica el orden que debe
	 * seguirse.
	 * 
	 * @param mercancias
	 * @param ascendente
	 * @return
	 */
	public Mercancia[] ordenaAscendenteDescendente(Mercancia[] mercancias, boolean ascendente) {
		if (ascendente) {
			Arrays.sort(mercancias);
		} else {
			Arrays.sort(mercancias, Collections.reverseOrder());
		}
		return mercancias;
	}

	/**
	 * La mercancía recibida es siempre parte del array recibido como parámetro.
	 * Devuelve un array en el que se ha eliminado la Mercancia indicada como
	 * parámetro
	 * 
	 * @param mercancias
	 * @param mercancia
	 * @return
	 */
	public Mercancia[] deleteMercancia(Mercancia[] mercancias, Mercancia mercancia) {

//		int i = 0;
//		for (int j = 0; j < mercancias.length; j++) {
//			if (mercancias[j] != mercancia) {
//				Mercancia temp = mercancias[i];
//				mercancias[i] = mercancias[j];
//				mercancias[j] = temp;
//				i++;
//			}
//		}
//
//		Mercancia[] mercanciasAux = new Mercancia[i];
//		for (int j = 0; j < mercanciasAux.length; j++) {
//			mercanciasAux[j] = mercancias[j];
//		}
//
//		return mercanciasAux;
		return Arrays.stream(mercancias).filter(mercanciaAux -> mercanciaAux != mercancia).toArray(Mercancia[]::new);
	}

	/**
	 * Devuelve un array en el que se han eliminado todas las mercancias que están
	 * por encima o por debajo del limite marcado. El boolean above indica si
	 * queremos eliminar las que están por encima o por debajo.
	 * 
	 * @param mercancias
	 * @param level
	 * @param above
	 * @return
	 */
	public Mercancia[] deleteAboveBelow(Mercancia[] mercancias, float level, boolean above) {
		return Arrays.stream(mercancias).filter(mercanciaAux -> (above && mercanciaAux.getVolumen() <= level)
				|| (!above && mercanciaAux.getVolumen() >= level)).toArray(Mercancia[]::new);
	}
}

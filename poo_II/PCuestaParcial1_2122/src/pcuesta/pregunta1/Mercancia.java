package pcuesta.pregunta1;

import java.util.Arrays;

/**
 * @author pablo
 * @date 2023-03-12
 */
public abstract class Mercancia implements Comparable<Mercancia> {

	private static int contadorId = 0;
	protected final int ID = contadorId++;
	protected float volumen = 0f;

	/**
	 * @param volumen
	 */
	public Mercancia() {
		volumen = calcularVolumen();
	}

	public abstract float calcularVolumen();

	public static void printMercancias(Mercancia[] mercancias) {
		System.out.println(Arrays.toString(mercancias));
	}

	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	@Override
	public int compareTo(Mercancia o) {

		if (volumen > o.volumen) {
			return 1;
		} else if (volumen < o.volumen) {
			return -1;
		}

		return 0;
	}

}

/**
 * 
 */
package pcuesta.pregunta1;

/**
 * @author pablo
 * @date 2023-03-12
 */
public class Irregular extends Mercancia {

	/**
	 * @param volumen
	 */
	public Irregular(float volumen) {
		super();
		super.volumen = volumen;
	}

	@Override
	public float calcularVolumen() {
		return volumen;
	}

	@Override
	public String toString() {
		return "\nIrregular - ID: " + ID + " Volumen: " + volumen;
	}

}

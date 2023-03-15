/**
 * 
 */
package pcuesta.pregunta1;

/**
 * @author pablo
 * @date 2023-03-12
 */
public class Ortoedro extends Mercancia {

	private float largo, alto, ancho;

	/**
	 * @param largo
	 * @param alto
	 * @param ancho
	 */
	public Ortoedro(float largo, float alto, float ancho) {
		this.largo = largo;
		this.alto = alto;
		this.ancho = ancho;
		calcularVolumen();
	}

	@Override
	public float calcularVolumen() {
		volumen = largo * ancho * alto;
		return volumen;
	}

	@Override
	public String toString() {
		return "\nCaja - ID: " + ID + " Volumen: " + calcularVolumen() + "(largo: " + largo + ", ancho: " + ancho
				+ ", alto: " + alto + ")";
	}

}

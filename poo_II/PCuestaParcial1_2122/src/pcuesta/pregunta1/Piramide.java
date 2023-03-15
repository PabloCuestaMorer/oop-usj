package pcuesta.pregunta1;

public class Piramide extends Mercancia {

	private float largo, ancho, alto;

	/**
	 * @param largo
	 * @param alto
	 * @param ancho
	 */
	public Piramide(float largo, float ancho, float alto) {
		this.largo = largo;
		this.ancho = ancho;
		this.alto = alto;
		calcularVolumen();
	}

	@Override
	public float calcularVolumen() {
		// 1/3 de la base por la altura
		volumen = (ancho * largo) * alto / 3;
		return volumen;
	}

	@Override
	public String toString() {
		return "\nPirámide - ID: " + ID + " Volumen: " + calcularVolumen() + "(largo: " + largo + ", ancho: " + ancho
				+ ", alto: " + alto + ")";
	}
}

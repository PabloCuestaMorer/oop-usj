package pcuesta.pregunta1;

public class Esfera extends Mercancia {

	private float radio;

	/**
	 * @param radio
	 */
	public Esfera(float radio) {
		this.radio = radio;
		calcularVolumen();
	}

	@Override
	public float calcularVolumen() {
		volumen = (float) (4 / 3 * Math.PI * Math.pow(radio, 3));
		return volumen;
	}

	@Override
	public String toString() {
		return "\nEsfera - ID: " + ID + " Volumen: " + calcularVolumen() + "(radio: " + radio + ")";
	}

}

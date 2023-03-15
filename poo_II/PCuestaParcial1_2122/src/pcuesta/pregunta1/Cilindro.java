package pcuesta.pregunta1;

public class Cilindro extends Mercancia {

	private float radio, altura;

	/**
	 * @param radio
	 * @param altura
	 */
	public Cilindro(float radio, float altura) {
		super();
		this.radio = radio;
		this.altura = altura;
	}

	@Override
	public float calcularVolumen() {
		volumen = (float) ((Math.PI * Math.pow(radio, 2)) * altura);
		return volumen;
	}

	@Override
	public String toString() {
		return "\nCilíndro - ID: " + ID + " Volumen: " + calcularVolumen() + "(radio: " + radio + ", alto: " + altura
				+ ")";
	}

}

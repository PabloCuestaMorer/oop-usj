package beans;

import java.util.Random;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-03-09
 */
public class Creyente extends Persona {

	public Creyente() {
		super(true); // siempre se crea en el estado infectado
	}

	@Override
	public void unDiaMas(Poblacion poblacion) {
		// ... tras haber tosido y sufrido como una persona normal
		super.unDiaMas(poblacion);
		// ... tiene un 20% de probabilidades de ser curado por su dios (si estaba infectado)
		Random rand = new Random();
		if (this.estado == Estado.INFECTADO && rand.nextDouble() < 0.2) {
			this.estado = Estado.CURADO;
		}
	}
}

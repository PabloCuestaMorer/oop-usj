/**
 * 
 */
package beans;

import java.util.Random;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-03-09
 */

public class Hipocondriaco extends Persona {

	public Hipocondriaco() {
		super(); // utiliza el constructor por defecto de Persona
	}

	public Hipocondriaco(boolean infectado) {
		super(infectado);
	}

	@Override
	public void recibirToses(Persona tosedor) {
		if (this.estado == Estado.MUERTO || this.estado == Estado.CURADO) {
			return; // no le afecta si está muerto o curado
		}

		Random rand = new Random();
		if (tosedor.estado == Estado.INFECTADO) {
			// tosida por un infectado 50% de posibilidades de contagiarse
			if (rand.nextDouble() < 0.5) {
				this.estado = Estado.INFECTADO;
			}
		} else if (tosedor.estado == Estado.CURADO) {
			// tosida por un curado 50% de posibilidades de curarse
			if (rand.nextDouble() < 0.5) {
				this.estado = Estado.CURADO;
			}
		}
	}
}

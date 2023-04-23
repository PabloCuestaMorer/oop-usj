package Antonio.plantas2;

import java.util.Random;


public class Plantas extends Persona {
	
	Random rand = new Random(System.currentTimeMillis());

	private int estatura;
	
	public Plantas () {
		super();
		estatura = 0;
	}
	
	@Override
	public void mostrarPersona() {

		System.out.print("Planta-"+ estatura+" ");
	}
	@Override
	public void unDiaMas (Poblacion pob) {
		
		estatura += rand.nextInt(5);
		
	}
}

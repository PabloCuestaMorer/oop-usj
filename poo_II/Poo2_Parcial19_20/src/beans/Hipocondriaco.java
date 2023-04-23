package beans;

public class Hipocondriaco extends Persona{

	public Hipocondriaco() {
		super();
	}
	
	@Override
	public void recibirToses(Persona tosedor) {
		if(tosedor.getState() == Persona.INFECTADO && this.state == Persona.SANO && rand.nextBoolean()) {
			this.state = INFECTADO;
		}
		
		if(tosedor.getState() == Persona.CURADO && this.state == Persona.INFECTADO && rand.nextBoolean()) {
			this.state = CURADO;
		}
	
	}
	
	@Override
	public void mostrarPersona() {
		if(this.state == INFECTADO) {
			System.out.print("H-I-"+this.health+" ");
		}else if(this.state == CURADO) {
			System.out.print("H-C" );
		}else if(this.state == SANO) {
			System.out.print("H-S ");
		}else if(this.state == MUERTO) {
			System.out.print("H-M ");
		}
	}
}

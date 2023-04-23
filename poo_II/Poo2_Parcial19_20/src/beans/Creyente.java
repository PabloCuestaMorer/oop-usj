package beans;

public class Creyente extends Persona {

	public Creyente() {
		super();
		this.state = Persona.INFECTADO;
	}

	@Override
	public void unDiaMas(Poblacion pob) {
		super.unDiaMas(pob);
		rezar();
	}

	public void rezar() {
		if (this.state == Persona.INFECTADO) {
			if (rand.nextInt(5) == 0) {
				this.state = Persona.CURADO;
			}
		}
	}
	
@Override
public void mostrarPersona() {
	if(this.state == INFECTADO) {
		System.out.print("C-I-"+this.health+" ");
	}else if(this.state == CURADO) {
		System.out.print("C-C ");
	}else if(this.state == SANO) {
		System.out.print("C-S ");
	}else if(this.state == MUERTO) {
		System.out.print("C-M ");
	}
}
}

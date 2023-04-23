package beans;

public class Sanitario extends Persona {

	private int pacientesDiarios;

	public Sanitario(int numPac) {
		super();
		this.pacientesDiarios = numPac;
	}


	public void unDiaMas(Poblacion pob) {
		super.unDiaMas(pob);
		curar(pob);
	}
	
	public void recibirToses(Persona tosedor) {
		super.recibirToses(tosedor);
	}

	public void curar(Poblacion pob) {
		for(int i = 0; i < pacientesDiarios; i++) {
			Persona elegido = pob.getPersona();
			elegido.recibeCura();
		}
		
	}
	@Override
	public void mostrarPersona() {
		if(this.state == INFECTADO) {
			System.out.print("S-I-"+this.health+" ");
		}else if(this.state == CURADO) {
			System.out.print("S-C ");
		}else if(this.state == SANO) {
			System.out.print("S-S ");
		}else if(this.state == MUERTO) {
			System.out.print("S-M ");
		}
	}
	

}

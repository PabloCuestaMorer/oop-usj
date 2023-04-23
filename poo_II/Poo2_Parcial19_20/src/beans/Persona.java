package beans;

import java.util.Random;

public class Persona {
	protected static final int SANO = 0;
	protected static final int CURADO = 1;
	protected static final int INFECTADO = 2;
	protected static final int MUERTO = 3;
	Random rand = new Random(System.currentTimeMillis());

	protected int health;
	protected int numContact;
	protected int state;
	
	
	public Persona() {

		this.health = rand.nextInt(80, 100);
		this.numContact = rand.nextInt(5);
		this.state = Persona.SANO;
	}

	public Persona(int estado) {
		this();
		this.state = estado;
	}
	public void unDiaMas (Poblacion pob) {
		if (this.state == Persona.MUERTO) return;
		toser(pob);
		sufirEnfermedad();
		
	}
	
	public void sufirEnfermedad() {
		if (this.state == Persona.INFECTADO){
			this.health -= rand.nextInt(50);	
		
		}
		if (this.health <= 0) {
			this.state = MUERTO;
		}
	}
	
	public void toser(Poblacion pob) {
		for (int i = 0; i< numContact; i++) {
			Persona p1 = pob.getPersona();
			p1.recibirToses(this);
		}
	}
	
	public void recibirToses(Persona tosedor) {
		if(tosedor.getState() == Persona.INFECTADO && this.state == Persona.SANO) {
			this.state = INFECTADO;
		}
		
		if(tosedor.getState() == Persona.CURADO && this.state == Persona.INFECTADO) {
			this.state = CURADO;
		}
			
	}
	
	public void recibeCura() {
		int newHealth = rand.nextInt(21);
		health += newHealth;
		
		if( this.state == INFECTADO) {
			this.state = CURADO;
		}
		
	}
	
	public int getState() {
		return this.state;
	}
	
	public void enfermarse() {
		this.state = INFECTADO;
	}
	
	public void mostrarPersona() {
		if(this.state == INFECTADO) {
			System.out.print("P-I-"+this.health+" ");
		}else if(this.state == CURADO) {
			System.out.print("P-C ");
		}else if(this.state == SANO) {
			System.out.print("P-S ");
		}else if(this.state == MUERTO) {
			System.out.print("P-M ");
		}
	}
}



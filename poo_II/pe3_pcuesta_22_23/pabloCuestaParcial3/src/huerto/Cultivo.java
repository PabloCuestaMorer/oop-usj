package huerto;

public class Cultivo {

	private String nombre;
	private Agua necesidadesAgua;
	private int numeroPlantas;
	
	public Cultivo(String nombre, Agua necesidadesAgua, int numeroPlantas) {		
		this.nombre = nombre;
		this.necesidadesAgua = necesidadesAgua;
		this.numeroPlantas = numeroPlantas;
	}

	public int getNumPlantas() {
		return numeroPlantas;
	}

	public Agua getAgua() {	
		return necesidadesAgua;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNumPlantas(int nuevoNumPlantas) {
		numeroPlantas = nuevoNumPlantas;		
	}

	public void setAgua(Agua nuevaAgua) {
		necesidadesAgua = nuevaAgua;
	}

	public void setNombre(String nuevoNombre) {
		nombre = nuevoNombre;
	}
	
}

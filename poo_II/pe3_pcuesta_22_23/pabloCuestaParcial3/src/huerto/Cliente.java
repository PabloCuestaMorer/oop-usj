package huerto;

public class Cliente {

	private String nombre;
	private String apellido;
	private int telefono;
	private int id;
	private static int currentID = 0;
	
	public Cliente() {
		this.id = currentID;
		currentID++;
	}
	
	public Cliente(String nombre, String apellido, int telefono) {
		this();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		
	}

	public Cliente(int phone) {
		this();
		this.nombre = "Nombre "+id;
		this.apellido = "Apellido "+id;
		this.telefono = phone;
	}

	public int getID() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getTelefono() {
		return telefono;
	}

	public void setNombre(String aValue) {
		this.nombre = aValue;
		
	}
	public void setApellido(String aValue) {
		this.apellido = aValue;
		
	}
	public void setTelefono(int aValue) {
		this.telefono = aValue;		
	}
	
	
}

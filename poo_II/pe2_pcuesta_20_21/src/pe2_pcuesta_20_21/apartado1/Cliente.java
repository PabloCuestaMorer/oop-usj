package pe2_pcuesta_20_21.apartado1;

/**
 * 1.4. Crea la clase Cliente, que contenga lo necesario para representar a un
 * usuario del huerto urbano: nombre, apellido, teléfono, id de cliente. Haz que
 * los clientes reciban ids consecutivos (1,2,3,…) conforme son creados y
 * asegurando que nunca se repite ninguno.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-04-25
 */
public class Cliente {
	private static int ultimoId = 0;
	private int idCliente;
	private String nombre;
	private String apellido;
	private String telefono;

	public Cliente(String nombre, String apellido, String telefono) {
		this.idCliente = asignarId();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	private synchronized int asignarId() {
		ultimoId += 1;
		return ultimoId;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "\n\t\tCliente{" + "nombre='" + nombre + '\'' + ", apellido='" + apellido + '\'' + ", telefono='"
				+ telefono + '\'' + ", idCliente=" + idCliente + '}';
	}
}

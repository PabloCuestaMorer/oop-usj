package pabloCuestaParcial2.apartado1;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-04-26
 */
public class Persona {

	private static int ultimoId = 0;

	private int idCliente;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private int edad;

	/**
	 * @param idCliente
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @param edad
	 */
	public Persona(String nombre, String apellido1, String apellido2, int edad) {
		this.idCliente = generarId();

		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
	}

	private synchronized int generarId() {
		ultimoId += 1;
		return ultimoId;
	}

	/**
	 * @return the idCliente
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido1
	 */
	public String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 the apellido1 to set
	 */
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	/**
	 * @return the apellido2
	 */
	public String getApellido2() {
		return apellido2;
	}

	/**
	 * @param apellido2 the apellido2 to set
	 */
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "\n\tPersona [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido1=" + apellido1
				+ ", apellido2=" + apellido2 + ", edad=" + edad + "]";
	}

}

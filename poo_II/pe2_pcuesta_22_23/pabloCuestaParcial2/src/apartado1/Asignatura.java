package apartado1;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class Asignatura {

	private static int ultimoId = 10_000;

	private int id;
	private String nombre;
	private int creditosECTS;
	/**
	 * @param id
	 * @param nombreAsignatura
	 * @param creditosECTS
	 */
	public Asignatura(String nombre, int creditosECTS) {
		this.id = generarId();
		
		this.nombre = nombre;
		this.creditosECTS = creditosECTS;
	}
	
	private synchronized int generarId() {
		ultimoId += 1;
		return ultimoId;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nombreAsignatura
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombreAsignatura the nombreAsignatura to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the creditosECTS
	 */
	public int getCreditosECTS() {
		return creditosECTS;
	}

	/**
	 * @param creditosECTS the creditosECTS to set
	 */
	public void setCreditosECTS(int creditosECTS) {
		this.creditosECTS = creditosECTS;
	}

	@Override
	public String toString() {
		return "\n\t\t\tAsignatura [id=" + id + ", nombre=" + nombre + ", creditosECTS="
				+ creditosECTS + "]";
	}
	
	

}

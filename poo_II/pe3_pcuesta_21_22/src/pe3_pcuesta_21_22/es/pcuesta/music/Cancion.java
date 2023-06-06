package pe3_pcuesta_21_22.es.pcuesta.music;

public class Cancion {

	private String nombre;
	private int duracion;
	private int year;
	private Style estilo;

	public Cancion(String nombre, int duracion, int year, Style estilo) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.year = year;
		this.estilo = estilo;
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
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the estilo
	 */
	public Style getEstilo() {
		return estilo;
	}

	/**
	 * @param estilo the estilo to set
	 */
	public void setEstilo(Style estilo) {
		this.estilo = estilo;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", duracion=" + duracion + ", year=" + year + ", estilo=" + estilo + "]\n";
	}

}

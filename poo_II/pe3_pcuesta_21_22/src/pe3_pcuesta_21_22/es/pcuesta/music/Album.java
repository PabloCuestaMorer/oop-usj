package pe3_pcuesta_21_22.es.pcuesta.music;

import java.util.ArrayList;

public class Album {

	private String nombre;
	private ArrayList<Cancion> canciones;

	public Album(String nombre) {
		this.nombre = nombre;
		this.canciones = new ArrayList<Cancion>();
	}

	public void addCancion(Cancion cancion) {
		canciones.add(cancion);

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
	 * @return the canciones
	 */
	public ArrayList<Cancion> getCanciones() {
		return canciones;
	}

	/**
	 * @param canciones the canciones to set
	 */
	public void setCanciones(ArrayList<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "Album [nombre=" + nombre + ", canciones=" + canciones + "]\n";
	}

}

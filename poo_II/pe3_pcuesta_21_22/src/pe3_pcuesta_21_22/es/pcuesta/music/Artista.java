package pe3_pcuesta_21_22.es.pcuesta.music;

import java.util.ArrayList;

public class Artista {

	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + ", albumes=" + albumes + "]\n";
	}

	private String nombre;
	private ArrayList<Album> albumes;

	public Artista(String nombre) {
		this.nombre = nombre;
		albumes = new ArrayList<Album>();
	}

	public void addAlbum(Album album) {
		albumes.add(album);

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
	 * @return the albumes
	 */
	public ArrayList<Album> getAlbumes() {
		return albumes;
	}

	/**
	 * @param albumes the albumes to set
	 */
	public void setAlbumes(ArrayList<Album> albumes) {
		this.albumes = albumes;
	}

}

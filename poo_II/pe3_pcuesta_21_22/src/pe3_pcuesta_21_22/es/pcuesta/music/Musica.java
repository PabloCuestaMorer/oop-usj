package pe3_pcuesta_21_22.es.pcuesta.music;

import java.util.ArrayList;

public class Musica {

	private String nombre;
	private ArrayList<Artista> artistas;

	public Musica(String nombre) {
		super();
		this.nombre = nombre;
		this.artistas = new ArrayList<Artista>();
	}

	public void addArtista(Artista artista) {
		artistas.add(artista);
	}

	public int getAlbumesNumber() {
		int albumCount = 0;
		for (Artista artista : artistas) {
			albumCount += artista.getAlbumes().size();
		}
		return albumCount;
	}

	public int getCancionesNumber() {
		int cancionesCount = 0;
		for (Artista artista : artistas) {
			for (Album album : artista.getAlbumes()) {
				cancionesCount += album.getCanciones().size();
			}
		}
		return cancionesCount;
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
	 * @return the artistas
	 */
	public ArrayList<Artista> getArtistas() {
		return artistas;
	}

	/**
	 * @param artistas the artistas to set
	 */
	public void setArtistas(ArrayList<Artista> artistas) {
		this.artistas = artistas;
	}

	@Override
	public String toString() {
		return "Musica [nombre=" + nombre + ", artistas=" + artistas + "]";
	}

}

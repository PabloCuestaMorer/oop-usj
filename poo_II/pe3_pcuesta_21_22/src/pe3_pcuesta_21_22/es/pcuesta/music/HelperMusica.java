package pe3_pcuesta_21_22.es.pcuesta.music;

import java.util.Random;

public class HelperMusica {

	public static Musica createMusica(int canciones, int albumes, int artistas, String nombre) {

		Musica musica = new Musica(nombre);

		for (int artistaID = 0; artistaID < artistas; artistaID++) {

			Artista artista = new Artista("Artista " + (artistaID + 1));
			musica.addArtista(artista);
			
			for (int albumID = 0; albumID < albumes; albumID++) {

				Album album = new Album("Album " + (albumID + 1));
				artista.addAlbum(album);
				for (int cancionID = 0; cancionID < canciones; cancionID++) {

					Cancion cancion = new Cancion("Cancion " + (cancionID + 1), randomYear(),randomDuration(),randomStyle());
					album.addCancion(cancion);

				}
			}

		}

		return musica;

	}
	
	private static int randomDuration() {
		Random r = new Random();
		return 60+r.nextInt(300);
	}
	
	private static int randomYear() {
		Random r = new Random();
		return 1950 + r.nextInt(70);
	}
	
	private static Style randomStyle() {
		Random r = new Random();
		
		Style[] styles = Style.values();
		return styles[r.nextInt(styles.length)];
		
	}
}

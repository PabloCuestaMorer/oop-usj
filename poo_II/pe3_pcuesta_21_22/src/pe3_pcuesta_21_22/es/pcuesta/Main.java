package pe3_pcuesta_21_22.es.pcuesta;

import pe3_pcuesta_21_22.es.pcuesta.music.HelperMusica;
import pe3_pcuesta_21_22.es.pcuesta.music.Musica;
import pe3_pcuesta_21_22.es.pcuesta.ui.MusicCollectionUI;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-06-01
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Utiliza HelperMusica para crear una colección de música
		Musica musica = HelperMusica.createMusica(2, 2, 2, "Ejemplo");

		// Inicializa la interfaz gráfica y le pasa la música
		MusicCollectionUI ui = new MusicCollectionUI(musica);

	}

}

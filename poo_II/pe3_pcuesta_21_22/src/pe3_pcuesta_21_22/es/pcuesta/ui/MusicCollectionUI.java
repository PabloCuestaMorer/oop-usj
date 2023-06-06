package pe3_pcuesta_21_22.es.pcuesta.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import pe3_pcuesta_21_22.es.pcuesta.music.Album;
import pe3_pcuesta_21_22.es.pcuesta.music.Artista;
import pe3_pcuesta_21_22.es.pcuesta.music.Musica;

public class MusicCollectionUI {
	private Musica musica;
	private JFrame frame;
	private JLabel lblNombreColeccion, lblNumeroArtistas, lblNumeroAlbumes, lblNumeroCanciones;
	private JTable table;

	// Constructor de la clase
	public MusicCollectionUI(Musica musica) {
		this.musica = musica;

		frame = new JFrame("Colección de Música");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Crear paneles y menús
		frame.add(createInfoPanel(), BorderLayout.EAST);
		frame.add(createTablePanel(), BorderLayout.CENTER);
		frame.setJMenuBar(createMenuBar());

		frame.setSize(800, 600); // Ajuste de tamaño
		frame.setVisible(true); // Hacer visible

		updateInfo(); // Actualizar información en pantalla
	}

	// Método para crear el panel de información
	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel(new GridLayout(4, 1));

		lblNombreColeccion = new JLabel();
		lblNumeroArtistas = new JLabel();
		lblNumeroAlbumes = new JLabel();
		lblNumeroCanciones = new JLabel();

		infoPanel.add(lblNombreColeccion);
		infoPanel.add(lblNumeroArtistas);
		infoPanel.add(lblNumeroAlbumes);
		infoPanel.add(lblNumeroCanciones);

		return infoPanel;
	}

	// Método para crear el panel de tabla
	private JPanel createTablePanel() {
		table = new JTable(new MusicTableModel(musica));
		JPanel tablePanel = new JPanel(new BorderLayout());
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

		return tablePanel;
	}

	// Método para crear el menú de la barra
	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		// Menús Append, Remove, y Clear
		menuBar.add(createAppendMenu());
		menuBar.add(createRemoveMenu());
		menuBar.add(createClearItem());

		return menuBar;
	}

	// Método para crear el menú Append
	private JMenu createAppendMenu() {
		JMenu menuAppend = new JMenu("Append");

		menuAppend.add(createAppendArtistItem());
		menuAppend.add(createAppendAlbumItem());
		menuAppend.add(createAppendSongItem());

		return menuAppend;
	}

	// Método para crear el elemento Append Artist
	private JMenuItem createAppendArtistItem() {
		JMenuItem menuItemArtist = new JMenuItem("Artist");

		menuItemArtist.addActionListener(e -> {
			musica.addArtista(new Artista("Artista Nuevo"));
			updateInfo();
		});

		return menuItemArtist;
	}

	// Método para crear el elemento Append Album
	private JMenuItem createAppendAlbumItem() {
		JMenuItem menuItemAlbum = new JMenuItem("Album");

		menuItemAlbum.addActionListener(e -> {
			if (!musica.getArtistas().isEmpty()) {
				musica.getArtistas().get(musica.getArtistas().size() - 1).addAlbum(new Album("Album Nuevo"));
				updateInfo();
			}
		});

		return menuItemAlbum;
	}

	// Método para crear el elemento Append Song
	private JMenuItem createAppendSongItem() {
		JMenuItem menuItemSong = new JMenuItem("Song");

		menuItemSong.addActionListener(e -> {
			SongDialog songDialog = new SongDialog(frame, "Nueva Canción", true);
			songDialog.setVisible(true);

			if (songDialog.isConfirmed() && !musica.getArtistas().isEmpty()) {
				Artista ultimoArtista = musica.getArtistas().get(musica.getArtistas().size() - 1);
				if (!ultimoArtista.getAlbumes().isEmpty()) {
					ultimoArtista.getAlbumes().get(ultimoArtista.getAlbumes().size() - 1)
							.addCancion(songDialog.getCancion());
					updateInfo();
				}
			}
		});

		return menuItemSong;
	}

	// Método para crear el menú Remove
	private JMenu createRemoveMenu() {
		JMenu menuRemove = new JMenu("Remove");

		menuRemove.add(createRemoveFirstArtistItem());
		menuRemove.add(createRemoveLastArtistItem());
		menuRemove.add(createRemoveRandomAlbumItem());

		return menuRemove;
	}

	// Método para crear el elemento Remove First Artist
	private JMenuItem createRemoveFirstArtistItem() {
		JMenuItem menuItemFirstArtist = new JMenuItem("First Artist");

		menuItemFirstArtist.addActionListener(e -> {
			if (!musica.getArtistas().isEmpty()) {
				musica.getArtistas().remove(0);
				updateInfo();
			}
		});

		return menuItemFirstArtist;
	}

	// Método para crear el elemento Remove Last Artist
	private JMenuItem createRemoveLastArtistItem() {
		JMenuItem menuItemLastArtist = new JMenuItem("Last Artist");

		menuItemLastArtist.addActionListener(e -> {
			if (!musica.getArtistas().isEmpty()) {
				musica.getArtistas().remove(musica.getArtistas().size() - 1);
				updateInfo();
			}
		});

		return menuItemLastArtist;
	}

	// Método para crear el elemento Remove Random Album
	private JMenuItem createRemoveRandomAlbumItem() {
		JMenuItem menuItemRandomAlbum = new JMenuItem("Random Album");

		menuItemRandomAlbum.addActionListener(e -> {
			if (!musica.getArtistas().isEmpty()) {
				Random rand = new Random();
				Artista randomArtist = musica.getArtistas().get(rand.nextInt(musica.getArtistas().size()));
				if (!randomArtist.getAlbumes().isEmpty()) {
					randomArtist.getAlbumes().remove(rand.nextInt(randomArtist.getAlbumes().size()));
					updateInfo();
				}
			}
		});

		return menuItemRandomAlbum;
	}

	// Método para crear el elemento Clear
	private JMenuItem createClearItem() {
		JMenuItem menuItemClear = new JMenuItem("Clear");

		menuItemClear.addActionListener(e -> {
			musica = new Musica("Nueva Colección");
			updateInfo();
		});

		return menuItemClear;
	}

	// Método para actualizar la información en pantalla
	public void updateInfo() {
		lblNombreColeccion.setText("Nombre de la colección: " + musica.getNombre());
		lblNumeroArtistas.setText("Número de artistas: " + musica.getArtistas().size());
		lblNumeroAlbumes.setText("Número de álbumes: " + musica.getAlbumesNumber());
		lblNumeroCanciones.setText("Número de canciones: " + musica.getCancionesNumber());

		table.setModel(new MusicTableModel(musica));
	}
}

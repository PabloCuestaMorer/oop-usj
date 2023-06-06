package pe3_pcuesta_21_22.es.pcuesta.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import pe3_pcuesta_21_22.es.pcuesta.music.Album;
import pe3_pcuesta_21_22.es.pcuesta.music.Artista;
import pe3_pcuesta_21_22.es.pcuesta.music.Cancion;
import pe3_pcuesta_21_22.es.pcuesta.music.Musica;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-06-01
 */

public class MusicTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 3489230491274591482L;

	private final List<Cancion> canciones;
	private final Map<Cancion, Artista> cancionArtistaMap;
	private final Map<Cancion, Album> cancionAlbumMap;
	private final String[] columnNames = { "Título", "Artista", "Álbum", "Año", "Duración", "Estilo" };

	public MusicTableModel(Musica musica) {
		canciones = new ArrayList<>();
		cancionArtistaMap = new HashMap<>();
		cancionAlbumMap = new HashMap<>();

		for (Artista artista : musica.getArtistas()) {
			for (Album album : artista.getAlbumes()) {
				for (Cancion cancion : album.getCanciones()) {
					canciones.add(cancion);
					cancionArtistaMap.put(cancion, artista);
					cancionAlbumMap.put(cancion, album);
				}
			}
		}
	}

	@Override
	public int getRowCount() {
		return canciones.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Cancion cancion = canciones.get(rowIndex);
		Artista artista = cancionArtistaMap.get(cancion);
		Album album = cancionAlbumMap.get(cancion);

		switch (columnIndex) {
		case 0:
			return cancion.getNombre();
		case 1:
			return artista.getNombre(); // Obtén el nombre del artista
		case 2:
			return album.getNombre(); // Obtén el nombre del álbum
		case 3:
			return cancion.getDuracion();
		case 4:
			return cancion.getYear();
		case 5:
			return cancion.getEstilo();
		default:
			return null;
		}
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex != 5; // La última columna no es editable
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Cancion cancion = canciones.get(rowIndex);
		Artista artista = cancionArtistaMap.get(cancion);
		Album album = cancionAlbumMap.get(cancion);

		switch (columnIndex) {
		case 0:
			cancion.setNombre((String) aValue);
			break;
		case 1:
			// Set el nombre del artista
			artista.setNombre((String) aValue);
			break;
		case 2:
			// Set el nombre del álbum
			album.setNombre((String) aValue);
			break;
		case 3:
			cancion.setDuracion((Integer) aValue);
			break;
		case 4:
			cancion.setYear((Integer) aValue);
			break;
		}

		fireTableCellUpdated(rowIndex, columnIndex);
	}

}

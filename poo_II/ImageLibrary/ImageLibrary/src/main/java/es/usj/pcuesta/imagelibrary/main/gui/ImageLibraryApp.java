package es.usj.pcuesta.imagelibrary.main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;
import es.usj.pcuesta.imagelibrary.main.controller.ImageAnalyzer;
import es.usj.pcuesta.imagelibrary.main.utils.ImageGenerator;
import es.usj.pcuesta.imagelibrary.main.utils.MetadataEditor;
import es.usj.pcuesta.imagelibrary.main.utils.RandomFolderGenerator;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-09
 */
public class ImageLibraryApp {
	private final static String IMG_FOLDER_PATH = "coleccion_imagenes";
	private static JTable imageInfoTable;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			createAndShowGUI();
		});
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Image Library");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);

		// Obtencion datos de las imágenes.
		ImageAnalyzer imageAnalyzer = new ImageAnalyzer();
		List<ImageInfo> images = new ArrayList<>();
		try {
			images = imageAnalyzer.analyzeImages(IMG_FOLDER_PATH);
		} catch (ImageReadException e1) {
			JOptionPane.showMessageDialog(frame, "Error al leer las imágenes en la carpeta: " + e1.getMessage(),
					"Error en la lectura de imágenes", JOptionPane.ERROR_MESSAGE);
			frame.dispose();
			return;
		}

		// Creacion de la tabla
		imageInfoTable = new JTable(new ImageInfoTableModel(images));
		imageInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane imageInfoScrollPane = new JScrollPane(imageInfoTable);
		imageInfoScrollPane.setPreferredSize(new Dimension(600, 400));
		frame.add(imageInfoScrollPane, BorderLayout.WEST);

		// JLabel
		JLabel imageView = new JLabel();
		imageView.setHorizontalAlignment(JLabel.CENTER);
		frame.add(imageView, BorderLayout.CENTER);

		// Listener para cada item img de la tabla
		imageInfoTable.getSelectionModel().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				int selectedRow = imageInfoTable.getSelectedRow();
				if (selectedRow >= 0) {
					String imagePath = (String) imageInfoTable.getValueAt(selectedRow, 1);
					try {
						BufferedImage image = Imaging.getBufferedImage(new File(imagePath));
						imageView.setIcon(new ImageIcon(image));
					} catch (IOException | ImageReadException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		JMenuBar menuBar = new JMenuBar();

		// Menú Archivo
		JMenu fileMenu = new JMenu("Archivo");
		menuBar.add(fileMenu);

		// Submenú Crear carpetas e imágenes
		JMenuItem createFoldersItem = new JMenuItem("Crear carpetas e imágenes");
		fileMenu.add(createFoldersItem);

		createFoldersItem.addActionListener(e -> {
			createFoldersAndImages();
			try {
				analyzeImages();
			} catch (ImageReadException e1) {
				JOptionPane.showMessageDialog(frame, "Error al leer las imágenes en la carpeta: " + e1.getMessage(),
						"Error en la lectura de imágenes", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				return;
			}
		});

		// Submenú Análisis
		JMenuItem analyzeItem = new JMenuItem("Análisis");
		fileMenu.add(analyzeItem);

		analyzeItem.addActionListener(e -> {
			try {
				analyzeImages();
			} catch (ImageReadException e1) {
				JOptionPane.showMessageDialog(frame, "Error al leer las imágenes en la carpeta: " + e1.getMessage(),
						"Error en la lectura de imágenes", JOptionPane.ERROR_MESSAGE);
				frame.dispose();
				return;
			}
		});

		// Submenú Filtros
		JMenuItem filtersItem = new JMenuItem("Filtros");
		fileMenu.add(filtersItem);

		filtersItem.addActionListener(e -> {
			applyFilters(frame);
		});

		frame.setJMenuBar(menuBar);

		frame.setVisible(true);
	}

	private static void createFoldersAndImages() {
		// Crear jerarquia de carpetas
		RandomFolderGenerator folderGenerator = new RandomFolderGenerator(5, 3, 1998, 2023);
		List<File> folders = folderGenerator.generateFolders(IMG_FOLDER_PATH);

		// Crear imágenes utilizando Graphics2D
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK };
		ImageGenerator imageGenerator = new ImageGenerator(100, 100, 800, 800, 20, colors);

		for (File folder : folders) {
			String filePath = folder.getAbsolutePath() + "/imagen_" + System.currentTimeMillis() + ".jpg";
			imageGenerator.createImage(filePath);

			// Editar metadatos utilizando Apache Commons Imaging
			MetadataEditor metadataEditor = new MetadataEditor();
			File[] images = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
			for (File image : images) {
				try {
					Date captureDate = MetadataEditor.getRandomCaptureDate(1998, 2023);
					Double latitude = Math.random() * 180 - 90;
					Double longitude = Math.random() * 360 - 180;
					metadataEditor.editMetadata(image.getAbsolutePath(), captureDate, latitude, longitude);
				} catch (ImageWriteException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void analyzeImages() throws ImageReadException {
		ImageAnalyzer imageAnalyzer = new ImageAnalyzer();
		List<ImageInfo> images = new ArrayList<>();
		images = imageAnalyzer.analyzeImages(IMG_FOLDER_PATH);
		System.out.println("Imágenes analizadas: " + images.size()); // Actualiza el modelo de la tabla
		ImageInfoTableModel tableModel = (ImageInfoTableModel) imageInfoTable.getModel();
		tableModel.updateImageInfoList(images);
	}

	private static void applyFilters(JFrame frame) {
		ImageAnalyzer imageAnalyzer = new ImageAnalyzer();
		ImageInfoTableModel tableModel = (ImageInfoTableModel) imageInfoTable.getModel();

		// Crea el cuadro de diálogo para seleccionar el filtro y el valor
		JDialog filterDialog = new JDialog(frame, "Filtrar imágenes", true);
		filterDialog.setSize(400, 200);
		filterDialog.setLocationRelativeTo(frame);
		filterDialog.setLayout(new GridLayout(3, 2));

		// Crea los componentes del cuadro de diálogo
		String[] filterOptions = { "Ancho", "Alto" };
		JComboBox<String> filterComboBox = new JComboBox<>(filterOptions);
		filterDialog.add(new JLabel("Filtrar por:"));
		filterDialog.add(filterComboBox);

		filterDialog.add(new JLabel("Valor mínimo:"));
		JTextField filterValueTextField = new JTextField();
		filterDialog.add(filterValueTextField);

		JButton cancelButton = new JButton("Cancelar");
		cancelButton.addActionListener(e -> filterDialog.dispose());
		filterDialog.add(cancelButton);

		JButton applyButton = new JButton("Aplicar");
		applyButton.addActionListener(e -> {
			String filterType = (String) filterComboBox.getSelectedItem();
			int filterValue;

			try {
				filterValue = Integer.parseInt(filterValueTextField.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(filterDialog, "Por favor, ingrese un valor válido.",
						"Error en el valor del filtro", JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Filtra la lista de imágenes usando el criterio seleccionado
			List<ImageInfo> filteredImages = new ArrayList<>();

			if ("Ancho".equals(filterType)) {
				filteredImages = imageAnalyzer.filterImages(tableModel.getImageInfoList(),
						img -> img.getWidth() >= filterValue);
			} else if ("Alto".equals(filterType)) {
				filteredImages = imageAnalyzer.filterImages(tableModel.getImageInfoList(),
						img -> img.getHeight() >= filterValue);
			}

			// Actualiza el modelo de la tabla con la lista de imágenes filtradas
			tableModel.updateImageInfoList(filteredImages);

			filterDialog.dispose();
		});
		filterDialog.add(applyButton);

		filterDialog.setVisible(true);
	}

}

package es.usj.pcuesta.imagelibrary.main.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.TableRowSorter;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;
import es.usj.pcuesta.imagelibrary.main.controller.ImageController;
import es.usj.pcuesta.imagelibrary.main.utils.ImageGenerator;
import es.usj.pcuesta.imagelibrary.main.utils.MetadataEditor;
import es.usj.pcuesta.imagelibrary.main.utils.RandomFolderGenerator;

/**
 * The ImageLibraryApp class is the main class for the Image Library
 * application. It provides a graphical user interface (GUI) for browsing and
 * analyzing images.
 * 
 * The application allows users to view image information in a table, display
 * selected images, create new folders and images, and analyze images in a
 * selected directory.
 * 
 * The GUI is built using Swing components and provides a menu bar, a table for
 * image information, an image display area, a search bar, and various menu
 * options.
 * 
 * The class also contains helper methods for initializing the GUI, loading
 * images, setting up the table, handling user interactions, and creating
 * folders and images.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-05-09
 */
public class ImageLibraryApp {

	private static String imagesCurrentPath = "coleccion_imagenes";
	private static JTable imageInfoTable;
	private static JLabel imageView;
	private static List<ImageInfo> allImages;

	/**
	 * The main method for starting the Image Library application. It invokes the
	 * creation and display of the GUI using the SwingUtilities class.
	 * 
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(ImageLibraryApp::createAndShowGUI);
	}

	/**
	 * Creates and displays the main GUI.
	 */
	private static void createAndShowGUI() {
		JFrame frame = initFrame();
		ImageController imageController = new ImageController();
		List<ImageInfo> images = getImages(imageController, frame);
		setupImageTable(frame, images);
		setupImageLabel(frame);
		setupMenu(frame);
		setupSearchBar(frame, imageController, (ImageInfoTableModel) imageInfoTable.getModel());
		frame.setVisible(true);
	}

	/**
	 * Initializes the main JFrame.
	 * 
	 * @return the initialized JFrame
	 */
	private static JFrame initFrame() {
		JFrame frame = new JFrame("Image Library");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		return frame;
	}

	/**
	 * Retrieves the images from the specified directory using the ImageController.
	 * 
	 * @param imageController the ImageController for analyzing images
	 * @param frame           the main JFrame
	 * @return the list of ImageInfo objects
	 */
	private static List<ImageInfo> getImages(ImageController imageController, JFrame frame) {
		allImages = new ArrayList<>();
		try {
			allImages = imageController.analyzeImages(imagesCurrentPath);
		} catch (ImageReadException e1) {
			showErrorMessage(frame, e1, "Error reading images");
			frame.dispose();
		}
		return new ArrayList<>(allImages);
	}

	/**
	 * Configures the image information table in the JFrame.
	 * 
	 * @param frame  the main JFrame
	 * @param images the list of ImageInfo objects
	 */
	private static void setupImageTable(JFrame frame, List<ImageInfo> images) {
		imageInfoTable = new JTable(new ImageInfoTableModel(images));
		TableRowSorter<ImageInfoTableModel> sorter = new TableRowSorter<>(
				(ImageInfoTableModel) imageInfoTable.getModel());
		imageInfoTable.setRowSorter(sorter);
		imageInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		imageInfoTable.getSelectionModel().addListSelectionListener(e -> displaySelectedImage(e));
		JScrollPane imageInfoScrollPane = new JScrollPane(imageInfoTable);
		imageInfoScrollPane.setPreferredSize(new Dimension(600, 400));
		frame.add(imageInfoScrollPane, BorderLayout.WEST);
	}

	/**
	 * Configures the image label in the JFrame.
	 * 
	 * @param frame the main JFrame
	 */
	private static void setupImageLabel(JFrame frame) {
		imageView = new JLabel();
		imageView.setHorizontalAlignment(JLabel.CENTER);
		frame.add(imageView, BorderLayout.CENTER);
	}

	/**
	 * Configures the menu in the JFrame.
	 * 
	 * @param frame the main JFrame
	 */
	private static void setupMenu(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		// File menu
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		// Create Folders and Images submenu
		setupCreateFoldersAndImagesItem(fileMenu, frame);
		// Analyze submenu
		setupAnalyzeItem(fileMenu, frame);

		frame.setJMenuBar(menuBar);
	}

	/**
	 * Handles image filtering based on the file name using a search bar.
	 * 
	 * @param frame           the main JFrame
	 * @param imageController the ImageController for filtering images
	 * @param tableModel      the table model for updating image data
	 */
	private static void setupSearchBar(JFrame frame, ImageController imageController, ImageInfoTableModel tableModel) {
		JPanel searchBar = new JPanel();
		searchBar.setLayout(new BorderLayout());

		JTextField searchField = new JTextField();
		searchBar.add(searchField, BorderLayout.CENTER);

		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(e -> {
			String name = searchField.getText();
			List<ImageInfo> filteredImages;
			if (name == null || name.isEmpty()) {
				// If no text in the search field, show all images
				filteredImages = new ArrayList<>(allImages);
			} else {
				// If there is text in the search field, filter the images
				filteredImages = imageController.filterByName(allImages, name);
			}
			tableModel.updateImageInfoList(filteredImages);
		});

		searchBar.add(searchButton, BorderLayout.EAST);
		frame.add(searchBar, BorderLayout.NORTH);
	}

	/**
	 * Displays the selected image in the image label.
	 * 
	 * @param e the list selection event
	 */
	private static void displaySelectedImage(ListSelectionEvent e) {
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
	}

	/**
	 * Configures the Create Folders and Images menu item.
	 * 
	 * @param fileMenu the File menu
	 * @param frame    the main JFrame
	 */
	private static void setupCreateFoldersAndImagesItem(JMenu fileMenu, JFrame frame) {
		JMenuItem createFoldersItem = new JMenuItem("New");
		fileMenu.add(createFoldersItem);

		createFoldersItem.addActionListener(e -> {
			// Show file chooser dialog
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnValue = fileChooser.showOpenDialog(frame);

			// Create folders and images in the selected directory
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedDirectory = fileChooser.getSelectedFile();
				imagesCurrentPath = selectedDirectory.getPath();
				createFoldersAndImages(imagesCurrentPath);
				try {
					analyzeImages(selectedDirectory.getPath());
				} catch (ImageReadException e1) {
					showErrorMessage(frame, e1, "Error reading images");
					frame.dispose();
				}
			}
		});
	}

	/**
	 * Configures the Analyze menu item.
	 * 
	 * @param fileMenu the File menu
	 * @param frame    the main JFrame
	 */
	private static void setupAnalyzeItem(JMenu fileMenu, JFrame frame) {
		JMenuItem analyzeItem = new JMenuItem("Open");
		fileMenu.add(analyzeItem);

		analyzeItem.addActionListener(e -> {
			// Show file chooser dialog
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnValue = fileChooser.showOpenDialog(frame);

			// If a directory is selected, analyze the images in that directory
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedDirectory = fileChooser.getSelectedFile();
				imagesCurrentPath = selectedDirectory.getPath();
				try {
					analyzeImages(imagesCurrentPath);
				} catch (ImageReadException e1) {
					showErrorMessage(frame, e1, "Error reading images");
					frame.dispose();
				}
			}
		});
	}

	/**
	 * Creates the folders and images in the specified directory.
	 * 
	 * @param directoryPath the directory path
	 */
	private static void createFoldersAndImages(String directoryPath) {
		// Create folder hierarchy
		RandomFolderGenerator folderGenerator = new RandomFolderGenerator(5, 3, 1998, 2023);
		List<File> folders = folderGenerator.generateFolders(directoryPath);

		// Create images using ImageGenerator
		Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE, Color.PINK };
		ImageGenerator imageGenerator = new ImageGenerator(100, 100, 800, 800, 20, colors);

		createImagesAndEditMetadata(folders, imageGenerator);
	}

	/**
	 * Creates the images and edits metadata in the specified folders.
	 * 
	 * @param folders        the list of folders
	 * @param imageGenerator the ImageGenerator for creating images
	 */
	private static void createImagesAndEditMetadata(List<File> folders, ImageGenerator imageGenerator) {
		for (File folder : folders) {
			String filePath = folder.getAbsolutePath() + "/image_" + System.currentTimeMillis() + ".jpg";
			imageGenerator.createImage(filePath);

			// Edit metadata using MetadataEditor
			MetadataEditor metadataEditor = new MetadataEditor();
			File[] images = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg"));
			for (File image : images) {
				try {
					Date captureDate = MetadataEditor.getRandomCaptureDate(1998, 2023);
					// Latitud valida -90 a +90 grados. Math.random() * 180 = 0 a 180, - 90 = -90 a
					// +90.
					Double latitude = Math.random() * 180 - 90;
					// Latitud valida -180 a +180 grados.
					Double longitude = Math.random() * 360 - 180;
					metadataEditor.editMetadata(image.getAbsolutePath(), captureDate, latitude, longitude);
				} catch (ImageWriteException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Analyzes the images in the specified path using the ImageController.
	 * 
	 * @param path the path to the images
	 * @throws ImageReadException if an error occurs while reading the images
	 */
	private static void analyzeImages(String path) throws ImageReadException {
		ImageController imageController = new ImageController();
		List<ImageInfo> images = new ArrayList<>();
		images = imageController.analyzeImages(path);
		System.out.println("Analyzed Images: " + images.size());
		//Update list of images
		allImages = getImages(imageController, initFrame());
		// Update table model
		ImageInfoTableModel tableModel = (ImageInfoTableModel) imageInfoTable.getModel();
		tableModel.updateImageInfoList(images);
	}

	/**
	 * Displays an error message dialog.
	 * 
	 * @param component    the parent component for the dialog
	 * @param e1           the exception that occurred
	 * @param errorMessage the error message to display
	 */
	private static void showErrorMessage(Component component, Exception e1, String errorMessage) {
		JOptionPane.showMessageDialog(component, errorMessage + "\n" + e1.getMessage(), "Error",
				JOptionPane.ERROR_MESSAGE);
	}

}

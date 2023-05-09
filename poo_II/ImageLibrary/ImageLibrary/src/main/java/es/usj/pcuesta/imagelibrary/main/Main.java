package es.usj.pcuesta.imagelibrary.main;

import java.awt.Color;
import java.io.File;
import java.util.Date;
import java.util.List;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;
import es.usj.pcuesta.imagelibrary.main.controller.ImageAnalyzer;
import es.usj.pcuesta.imagelibrary.main.utils.ImageGenerator;
import es.usj.pcuesta.imagelibrary.main.utils.MetadataEditor;
import es.usj.pcuesta.imagelibrary.main.utils.RandomFolderGenerator;

public class Main {
	public static void main(String[] args) throws ImageReadException {

//--------------------1. Crear colección de imágenes (~3 puntos):
		// Crear jerarquia de carpetas
		RandomFolderGenerator folderGenerator = new RandomFolderGenerator(5, 3, 1998, 2023);
		List<File> folders = folderGenerator.generateFolders("coleccion_imagenes");

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

//-------------------- 2. Análisis de imágenes (~3 puntos):

		ImageAnalyzer imageAnalyzer = new ImageAnalyzer();

		// 2.2. Analizar imágenes en una carpeta dada
		List<ImageInfo> images = imageAnalyzer.analyzeImages("coleccion_imagenes");
		System.out.println("Imágenes analizadas: " + images.size());

		// 2.3. Ordenar colecciones de imágenes
		imageAnalyzer.sortImages(images, ImageAnalyzer.SortCriteria.DATE_ASCENDING);
		System.out.println("\nImágenes ordenadas por fecha de captura ascendente:");
		for (ImageInfo image : images) {
			System.out.println(image);
		}

		// 2.4. Filtrar colecciones de imágenes
		List<ImageInfo> filteredImages = imageAnalyzer.filterImages(images, img -> img.getWidth() >= 500);
		System.out.println("\nImágenes filtradas con ancho de al menos 500 píxeles:");
		for (ImageInfo image : filteredImages) {
			System.out.println(image);
		}
	}
}
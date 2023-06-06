package es.usj.pcuesta.imagelibrary.main.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.imaging.ImageReadException;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;
import es.usj.pcuesta.imagelibrary.main.utils.MetadataEditor;

/**
 * The ImageController class handles the analysis and filtering of images. It
 * provides methods for analyzing images in a folder, processing individual
 * image files, and filtering images by name.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class ImageController {
	private static final String JPG = ".jpg";
	private static final String JPEG = ".jpeg";
	private static final String PNG = ".png";

	/**
	 * Analyzes the images in the specified folder and returns a list of ImageInfo
	 * objects representing the analyzed images.
	 * 
	 * @param folderPath the path to the folder containing the images
	 * @return a list of ImageInfo objects representing the analyzed images
	 * @throws ImageReadException if an error occurs during image analysis
	 */
	public List<ImageInfo> analyzeImages(String folderPath) throws ImageReadException {
		List<ImageInfo> imageInfoList = new ArrayList<>();
		File folder = new File(folderPath);
		analyzeFolder(folder, imageInfoList);
		return imageInfoList;
	}

	private void analyzeFolder(File folder, List<ImageInfo> imageInfoList) {
		MetadataEditor metadataEditor = new MetadataEditor();

		File[] files = folder.listFiles();
		if (files == null) {
			return;
		}

		for (File file : files) {
			if (file.isDirectory()) {
				analyzeFolder(file, imageInfoList);
			} else if (isImage(file)) {
				processImageFile(file, imageInfoList, metadataEditor);
			}
		}
	}

	private void processImageFile(File file, List<ImageInfo> imageInfoList, MetadataEditor metadataEditor) {
		try {
			String fileName = file.getName();
			String filePath = file.getAbsolutePath();
			Date captureDate = metadataEditor.getExifCaptureDate(filePath);
			Double[] gpsCoordinates = metadataEditor.getExifGPSCoordinates(filePath);
			Double latitude = (gpsCoordinates != null && gpsCoordinates.length > 0) ? gpsCoordinates[0] : null;
			Double longitude = (gpsCoordinates != null && gpsCoordinates.length > 1) ? gpsCoordinates[1] : null;

			int[] imageSize = metadataEditor.getImageSize(filePath);
			Integer width = (imageSize != null && imageSize.length > 0) ? imageSize[0] : null;
			Integer height = (imageSize != null && imageSize.length > 1) ? imageSize[1] : null;

			ImageInfo imageInfo = new ImageInfo(fileName, filePath, captureDate, latitude, longitude, width, height);

			imageInfoList.add(imageInfo);
		} catch (IOException | ImageReadException e) {
			System.err.println("Error analyzing the image: " + file.getAbsolutePath());
			e.printStackTrace();
		}
	}

	private boolean isImage(File file) {
		String fileName = file.getName().toLowerCase();
		return fileName.endsWith(JPG) || fileName.endsWith(JPEG) || fileName.endsWith(PNG);
	}

	/**
	 * Filters the given list of images by the specified name. Only the images whose
	 * file names contain the specified name will be included in the result.
	 * 
	 * @param images the list of images to filter
	 * @param name   the name to filter by
	 * @return a list of ImageInfo objects that match the filter criteria
	 */
	public List<ImageInfo> filterByName(List<ImageInfo> images, String name) {
		List<ImageInfo> filteredImages = new ArrayList<>();
		for (ImageInfo image : images) {
			if (image.getFileName().contains(name)) {
				filteredImages.add(image);
			}
		}
		return filteredImages;
	}
}

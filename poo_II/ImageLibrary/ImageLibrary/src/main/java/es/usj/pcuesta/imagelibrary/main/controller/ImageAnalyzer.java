package es.usj.pcuesta.imagelibrary.main.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.imaging.ImageReadException;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;
import es.usj.pcuesta.imagelibrary.main.utils.MetadataEditor;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class ImageAnalyzer {
	public List<ImageInfo> analyzeImages(String folderPath) throws ImageReadException {
		List<ImageInfo> imageInfoList = new ArrayList<>();
		File folder = new File(folderPath);
		analyzeFolder(folder, imageInfoList);
		return imageInfoList;
	}

	private void analyzeFolder(File folder, List<ImageInfo> imageInfoList) throws ImageReadException {
		MetadataEditor metadataEditor = new MetadataEditor();

		for (File file : folder.listFiles()) {
			if (file.isDirectory()) {
				analyzeFolder(file, imageInfoList);
			} else if (isImage(file)) {
				try {
					String fileName = file.getName();
					String filePath = file.getAbsolutePath();
					Date captureDate = metadataEditor.getExifCaptureDate(filePath);
					Double[] gpsCoordinates = metadataEditor.getExifGPSCoordinates(filePath);
					int[] imageSize = metadataEditor.getImageSize(filePath);

					ImageInfo imageInfo = new ImageInfo(fileName, filePath, captureDate, gpsCoordinates[0],
							gpsCoordinates[1], imageSize[0], imageSize[1]);

					imageInfoList.add(imageInfo);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private boolean isImage(File file) {
		String fileName = file.getName().toLowerCase();
		return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg") || fileName.endsWith(".png");
	}

	public enum SortCriteria {
		DATE_ASCENDING, DATE_DESCENDING, WIDTH_ASCENDING, WIDTH_DESCENDING, HEIGHT_ASCENDING, HEIGHT_DESCENDING
	}

	public void sortImages(List<ImageInfo> images, SortCriteria criteria) {
		Comparator<ImageInfo> comparator = null;

		switch (criteria) {
		case DATE_ASCENDING:
			comparator = (img1, img2) -> {
				if (img1.getCaptureDate() == null) {
					return img2.getCaptureDate() == null ? 0 : -1;
				}
				if (img2.getCaptureDate() == null) {
					return 1;
				}
				return img1.getCaptureDate().compareTo(img2.getCaptureDate());
			};
			break;
		case DATE_DESCENDING:
			comparator = (img1, img2) -> {
				if (img1.getCaptureDate() == null) {
					return img2.getCaptureDate() == null ? 0 : 1;
				}
				if (img2.getCaptureDate() == null) {
					return -1;
				}
				return img2.getCaptureDate().compareTo(img1.getCaptureDate());
			};
			break;
		case WIDTH_ASCENDING:
			comparator = Comparator.comparingInt(ImageInfo::getWidth);
			break;
		case WIDTH_DESCENDING:
			comparator = Comparator.comparingInt(ImageInfo::getWidth).reversed();
			break;
		case HEIGHT_ASCENDING:
			comparator = Comparator.comparingInt(ImageInfo::getHeight);
			break;
		case HEIGHT_DESCENDING:
			comparator = Comparator.comparingInt(ImageInfo::getHeight).reversed();
			break;
		}

		if (comparator != null) {
			images.sort(comparator);
		}
	}

	public List<ImageInfo> filterImages(List<ImageInfo> images, Predicate<ImageInfo> filter) {
		return images.stream().filter(filter).collect(Collectors.toList());
	}
}

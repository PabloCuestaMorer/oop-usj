package es.usj.pcuesta.imagelibrary.main.beans;

import java.util.Date;

/**
 * 2.1. (Formato) Diseña una clase/clases adecuadas para almacenar la
 * información relevante de las imágenes. Decide que información quieres guardar
 * de cada imagen, y en que colección/colecciones guardas las imágenes.
 * 
 * The ImageInfo class represents relevant information about an image. It stores
 * attributes such as file name, file path, capture date, coordinates, width,
 * and height.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-05-02
 */
public class ImageInfo {
	private String fileName;
	private String filePath;
	private Date captureDate;
	private Double latitude;
	private Double longitude;
	private int width;
	private int height;

	/**
	 * Constructs a new ImageInfo object with the specified attributes.
	 * 
	 * @param fileName    the file name of the image
	 * @param filePath    the file path of the image
	 * @param captureDate the capture date of the image
	 * @param latitude    the latitude coordinate of the image's location
	 * @param longitude   the longitude coordinate of the image's location
	 * @param width       the width of the image in pixels
	 * @param height      the height of the image in pixels
	 */
	public ImageInfo(String fileName, String filePath, Date captureDate, Double latitude, Double longitude, int width,
			int height) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.captureDate = captureDate;
		this.latitude = latitude;
		this.longitude = longitude;
		this.width = width;
		this.height = height;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Date getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(Date captureDate) {
		this.captureDate = captureDate;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "ImageInfo{" + "fileName='" + fileName + '\'' + ", filePath='" + filePath + '\'' + ", captureDate="
				+ captureDate + ", latitude=" + latitude + ", longitude=" + longitude + ", width=" + width + ", height="
				+ height + '}';
	}
}

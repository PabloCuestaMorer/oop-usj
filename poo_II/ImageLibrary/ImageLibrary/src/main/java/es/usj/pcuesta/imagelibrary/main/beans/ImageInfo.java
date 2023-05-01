package es.usj.pcuesta.imagelibrary.main.beans;

import java.util.Date;

/**
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

	// Getters y setters para cada atributo

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

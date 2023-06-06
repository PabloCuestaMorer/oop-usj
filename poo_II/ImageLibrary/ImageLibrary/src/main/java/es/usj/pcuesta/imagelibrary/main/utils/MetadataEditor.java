package es.usj.pcuesta.imagelibrary.main.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.common.RationalNumber;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.exif.ExifRewriter;
import org.apache.commons.imaging.formats.tiff.TiffField;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.ExifTagConstants;
import org.apache.commons.imaging.formats.tiff.constants.GpsTagConstants;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputDirectory;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;

/**
 * Utility class for editing metadata of images. Supports modifying capture date
 * and GPS coordinates. Provides methods to read image size, capture date, and
 * GPS coordinates from metadata. Can generate random capture dates within a
 * specified range.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-05-01
 */
public class MetadataEditor {

	/**
	 * Modifies the metadata of an image by updating the capture date and GPS
	 * coordinates.
	 * 
	 * @param imagePath   the path to the image
	 * @param captureDate the new capture date
	 * @param latitude    the new latitude coordinate
	 * @param longitude   the new longitude coordinate
	 * @throws ImageWriteException if an error occurs while writing the image
	 *                             metadata
	 */
	public void editMetadata(String imagePath, Date captureDate, Double latitude, Double longitude)
			throws ImageWriteException {
		// Temporary file for image processing
		File imageFile = new File(imagePath);
		File tempImageFile = new File(imagePath + "_temp");

		// Read original image bytes
		byte[] imageBytes = null;
		try {
			imageBytes = Files.readAllBytes(Paths.get(imagePath));
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		// Modify image metadata
		try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(imageBytes);
				FileOutputStream fos = new FileOutputStream(tempImageFile)) {

			// Get the EXIF metadata set of the image
			TiffOutputSet outputSet = getOutputSet(imageFile);
			if (outputSet == null) {
				System.err.println("Cannot edit image metadata: " + imagePath);
				return;
			}

			TiffOutputDirectory exifDirectory = outputSet.getOrCreateExifDirectory();

			// Modify capture date
			if (captureDate != null) {
				exifDirectory.removeField(ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL);
				exifDirectory.add(ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL,
						new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").format(captureDate));
			}

			// Modify GPS coordinates
			if (latitude != null && longitude != null) {
				TiffOutputDirectory gpsDirectory = outputSet.getOrCreateGPSDirectory();
				gpsDirectory.removeField(GpsTagConstants.GPS_TAG_GPS_LATITUDE_REF);
				gpsDirectory.removeField(GpsTagConstants.GPS_TAG_GPS_LATITUDE);
				gpsDirectory.removeField(GpsTagConstants.GPS_TAG_GPS_LONGITUDE_REF);
				gpsDirectory.removeField(GpsTagConstants.GPS_TAG_GPS_LONGITUDE);

				String latitudeRef = latitude < 0 ? "S" : "N";
				String longitudeRef = longitude < 0 ? "W" : "E";
				double[] latitudeDMS = toDMS(Math.abs(latitude));
				double[] longitudeDMS = toDMS(Math.abs(longitude));

				gpsDirectory.add(GpsTagConstants.GPS_TAG_GPS_LATITUDE_REF, latitudeRef);
				gpsDirectory.add(GpsTagConstants.GPS_TAG_GPS_LATITUDE, toRationalNumbers(latitudeDMS));
				gpsDirectory.add(GpsTagConstants.GPS_TAG_GPS_LONGITUDE_REF, longitudeRef);
				gpsDirectory.add(GpsTagConstants.GPS_TAG_GPS_LONGITUDE, toRationalNumbers(longitudeDMS));
			}

			// Write the metadata to the image
			new ExifRewriter().updateExifMetadataLossless(byteArrayInputStream, fos, outputSet);

			// Replace the temporary image with the original image
			Files.move(tempImageFile.toPath(), imageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		} catch (ImageReadException | IOException e) {
			e.printStackTrace();
		}
	}

	private TiffOutputSet getOutputSet(File imageFile) throws ImageReadException, IOException, ImageWriteException {
		ImageMetadata metadata = Imaging.getMetadata(imageFile);
		if (metadata instanceof JpegImageMetadata) {
			JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
			TiffImageMetadata exifMetadata = jpegMetadata.getExif();
			if (exifMetadata != null) {
				return exifMetadata.getOutputSet();
			}
		}
		return new TiffOutputSet();
	}

	private double[] toDMS(double decimalDegrees) {
		double degrees = Math.floor(decimalDegrees);
		decimalDegrees = (decimalDegrees - degrees) * 60;
		double minutes = Math.floor(decimalDegrees);
		double seconds = (decimalDegrees - minutes) * 60;
		return new double[] { degrees, minutes, seconds };
	}

	private RationalNumber[] toRationalNumbers(double[] dms) {
		RationalNumber[] rationalNumbers = new RationalNumber[dms.length];
		for (int i = 0; i < dms.length; i++) {
			rationalNumbers[i] = RationalNumber.valueOf(dms[i]);
		}
		return rationalNumbers;
	}

	/**
	 * Retrieves the capture date from the EXIF metadata of an image.
	 * 
	 * @param imagePath the path to the image
	 * @return the capture date, or null if it cannot be found
	 * @throws IOException        if an error occurs while reading the image
	 * @throws ImageReadException if an error occurs while reading the image
	 *                            metadata
	 */
	public Date getExifCaptureDate(String imagePath) throws IOException, ImageReadException {
		File imageFile = new File(imagePath);
		ImageMetadata metadata = Imaging.getMetadata(imageFile);
		if (metadata instanceof JpegImageMetadata) {
			JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
			TiffField dateTimeField = jpegMetadata
					.findEXIFValueWithExactMatch(ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL);
			if (dateTimeField != null) {
				String dateTimeString = dateTimeField.getStringValue();
				try {
					return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(dateTimeString);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * Retrieves the GPS coordinates from the EXIF metadata of an image.
	 * 
	 * @param imagePath the path to the image
	 * @return an array containing the latitude and longitude coordinates, or null
	 *         if they cannot be found
	 * @throws IOException        if an error occurs while reading the image
	 * @throws ImageReadException if an error occurs while reading the image
	 *                            metadata
	 */
	public Double[] getExifGPSCoordinates(String imagePath) throws IOException, ImageReadException {
		File imageFile = new File(imagePath);
		ImageMetadata metadata = Imaging.getMetadata(imageFile);
		if (metadata instanceof JpegImageMetadata) {
			JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
			TiffImageMetadata.GPSInfo gpsInfo = jpegMetadata.getExif().getGPS();
			if (gpsInfo != null) {
				Double latitude = gpsInfo.getLatitudeAsDegreesNorth();
				Double longitude = gpsInfo.getLongitudeAsDegreesEast();
				return new Double[] { latitude, longitude };
			}
		}
		return null;
	}

	/**
	 * Retrieves the size (width and height) of an image.
	 * 
	 * @param imagePath the path to the image
	 * @return an array containing the width and height of the image
	 * @throws IOException        if an error occurs while reading the image
	 * @throws ImageReadException if an error occurs while reading the image
	 *                            metadata
	 */
	public int[] getImageSize(String imagePath) throws IOException, ImageReadException {
		File imageFile = new File(imagePath);
		BufferedImage image = Imaging.getBufferedImage(imageFile);
		int width = image.getWidth();
		int height = image.getHeight();
		return new int[] { width, height };
	}

	/**
	 * Generates a random capture date within the specified range of years.
	 * 
	 * @param minYear the minimum year (inclusive)
	 * @param maxYear the maximum year (inclusive)
	 * @return a random capture date within the specified range
	 */
	public static Date getRandomCaptureDate(int minYear, int maxYear) {
		Random random = new Random();
		int randomYear = random.nextInt(minYear, (maxYear + 1));
		int randomMonth = random.nextInt(12) + 1;
		int randomDay = random.nextInt(30) + 1; // To simplify, all months have at least 30 days
		int randomHour = random.nextInt(24);
		int randomMinute = random.nextInt(60);
		int randomSecond = random.nextInt(60);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String randomDateString = String.format("%d-%02d-%02d %02d:%02d:%02d", randomYear, randomMonth, randomDay,
				randomHour, randomMinute, randomSecond);

		try {
			return dateFormat.parse(randomDateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}

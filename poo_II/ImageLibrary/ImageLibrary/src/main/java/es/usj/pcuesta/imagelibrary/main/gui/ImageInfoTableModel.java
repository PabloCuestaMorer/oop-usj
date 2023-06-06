package es.usj.pcuesta.imagelibrary.main.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;

/**
 * The ImageInfoTableModel class is a custom table model that is used to display
 * image information in a table. It extends the AbstractTableModel class and
 * provides the necessary methods to populate the table with data.
 * 
 * The table model contains columns for the file name, file path, capture date,
 * latitude, longitude, width, and height. It accepts a list of ImageInfo
 * objects and uses the data from these objects to populate the table.
 * 
 * @author Pablo Cuesta Morer
 * @date 2023-05-09
 */
class ImageInfoTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 2572195799774188771L;

	private final String[] columnNames = { "File Name", "File Path", "Capture Date", "Latitude", "Longitude", "Width",
			"Height" };
	private List<ImageInfo> imageInfoList;

	/**
	 * Constructs an ImageInfoTableModel object with the specified list of ImageInfo
	 * objects.
	 * 
	 * @param imageInfoList the list of ImageInfo objects
	 */
	public ImageInfoTableModel(List<ImageInfo> imageInfoList) {
		this.imageInfoList = imageInfoList;
	}

	/**
	 * Returns the number of rows in the table.
	 * 
	 * @return the number of rows
	 */
	@Override
	public int getRowCount() {
		return imageInfoList != null ? imageInfoList.size() : 0;
	}

	/**
	 * Returns the number of columns in the table.
	 * 
	 * @return the number of columns
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Returns the value at the specified row and column in the table.
	 * 
	 * @param rowIndex    the row index
	 * @param columnIndex the column index
	 * @return the value at the specified row and column
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		ImageInfo imageInfo = imageInfoList.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return imageInfo.getFileName();
		case 1:
			return imageInfo.getFilePath();
		case 2:
			return imageInfo.getCaptureDate();
		case 3:
			return imageInfo.getLatitude();
		case 4:
			return imageInfo.getLongitude();
		case 5:
			return imageInfo.getWidth();
		case 6:
			return imageInfo.getHeight();
		default:
			return null;
		}
	}

	/**
	 * Returns the name of the specified column in the table.
	 * 
	 * @param column the column index
	 * @return the name of the specified column
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	/**
	 * Updates the list of ImageInfo objects used by the table model and notifies
	 * the table of the data change.
	 * 
	 * @param imageInfoList the new list of ImageInfo objects
	 */
	public void updateImageInfoList(List<ImageInfo> imageInfoList) {
		this.imageInfoList = imageInfoList;
		fireTableDataChanged();
	}

	/**
	 * Returns the current list of ImageInfo objects used by the table model.
	 * 
	 * @return the list of ImageInfo objects
	 */
	public List<ImageInfo> getImageInfoList() {
		return imageInfoList;
	}
}

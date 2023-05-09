package es.usj.pcuesta.imagelibrary.main.gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import es.usj.pcuesta.imagelibrary.main.beans.ImageInfo;
import es.usj.pcuesta.imagelibrary.main.controller.ImageAnalyzer;
import es.usj.pcuesta.imagelibrary.main.controller.ImageAnalyzer.SortCriteria;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-09
 */
class ImageInfoTableModel extends AbstractTableModel {
	private static final long serialVersionUID = 2572195799774188771L;

	private final String[] columnNames = { "File Name", "File Path", "Capture Date", "Latitude", "Longitude", "Width",
			"Height" };
	private List<ImageInfo> imageInfoList;

	public ImageInfoTableModel(List<ImageInfo> imageInfoList) {
		this.imageInfoList = imageInfoList;
	}

	@Override
	public int getRowCount() {
		return imageInfoList != null ? imageInfoList.size() : 0;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

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

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void updateImageInfoList(List<ImageInfo> imageInfoList) {
		this.imageInfoList = imageInfoList;
		fireTableDataChanged();
	}

	public List<ImageInfo> getImageInfoList() {
		return imageInfoList;
	}

	public void sort(SortCriteria criteria) {
		ImageAnalyzer analyzer = new ImageAnalyzer();
		analyzer.sortImages(imageInfoList, criteria);
		fireTableDataChanged();
	}
}

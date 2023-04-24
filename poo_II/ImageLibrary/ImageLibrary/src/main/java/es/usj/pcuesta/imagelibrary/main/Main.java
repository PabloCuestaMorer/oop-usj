package es.usj.pcuesta.imagelibrary.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class Main {
	private static Random rand = new Random();

	public static void main(String[] args) {
		// 1.1
//		generateFolders("C:\\Users\\pablo\\Downloads\\ImageLibrary2", 10, 3);

		// 1.2
		String imageName = "image-" + System.currentTimeMillis() + ".png";
		String imagePath = "C:\\Users\\pablo\\Downloads\\" + imageName;
		int imageWidth = 600;
		int imageHeight = 600;
		int numPrimitives = rand.nextInt(10, 30);
		int maxLineWidth = rand.nextInt(5, 30);
		int maxRectSize = rand.nextInt(10, 150);
		int maxOvalSize = rand.nextInt(10, 150);
		Color[] backgroundColors = { Color.WHITE, Color.LIGHT_GRAY, Color.GRAY, Color.DARK_GRAY, Color.BLACK };
		Color[] primitiveColors = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA };
		Color backgroundColor = primitiveColors[rand.nextInt(backgroundColors.length)];
		Color primitiveColor = primitiveColors[rand.nextInt(primitiveColors.length)];
		try {
			createImage(imagePath, imageWidth, imageHeight, numPrimitives, maxLineWidth, maxRectSize, maxOvalSize,
					backgroundColor, primitiveColor);
			System.out.println("Image created: " + imagePath);
		} catch (IOException e) {
			System.err.println("Error creating image: " + e.getMessage());
		}
	}

	/**
	 * Generates a random folder hierarchy with different levels of depth and width.
	 *
	 * @param rootPath           the path of the root folder
	 * @param maxFoldersPerLevel the maximum number of folders per level
	 * @param maxLevels          the maximum number of levels
	 * @return
	 * @return
	 */
	public static void generateFolders(String rootPath, int maxFoldersPerLevel, int maxLevels) {
		File root = new File(rootPath);
		// Create the root folder if it doesn't exist yet
		if (!root.exists()) {
			root.mkdirs();
		}
		// Recursively generate the subfolders
		generateFoldersRecursive(root, maxFoldersPerLevel, maxLevels);
	}

	/**
	 * Generates a random folder hierarchy with different levels of depth and width.
	 *
	 * @param rootPath           the path of the root folder
	 * @param maxFoldersPerLevel the maximum number of folders per level
	 * @param maxLevels          the maximum number of levels
	 */
	private static void generateFoldersRecursive(File currentFolder, int maxFoldersPerLevel, int maxLevels) {
		// Generate a random number of subfolders to create for the current folder
		int numFolders = rand.nextInt(maxFoldersPerLevel) + 1;

		for (int i = 0; i < numFolders; i++) {
			String folderName = "" + rand.nextInt(1900, 2023);
			File newFolder = new File(currentFolder.getPath() + "/" + folderName);
			newFolder.mkdirs();

			// maximum level not reached, then recursively generate subfolders
			if (maxLevels > 1) {
				generateFoldersRecursive(newFolder, maxFoldersPerLevel, maxLevels - 1);
			}
		}
	}

	private enum PrimitiveType {
		LINE, RECTANGLE, OVAL, POLYGON
	}

	/**
	 * Creates a new image using the Graphics2D library and saves it to the
	 * specified path.
	 *
	 * @param path            the path where the image file will be saved
	 * @param width           the width of the image
	 * @param height          the height of the image
	 * @param numPrimitives   the number of primitive shapes to use
	 * @param maxLineWidth    the maximum width of a line shape
	 * @param maxRectSize     the maximum size of a rectangle shape
	 * @param maxOvalSize     the maximum size of an oval shape
	 * @param backgroundColor the background color of the image
	 * @param primitiveColor  the color to use for the primitive shapes
	 * @throws IOException if there is an error writing the image file
	 */
	public static void createImage(String path, int width, int height, int numPrimitives, int maxLineWidth,
			int maxRectSize, int maxOvalSize, Color backgroundColor, Color primitiveColor) throws IOException {

		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();

		// Fill the background with the specified color
		g2d.setColor(backgroundColor);
		g2d.fillRect(0, 0, width, height);

		// Draw the primitive shapes
		for (int i = 0; i < numPrimitives; i++) {
			// Generate a random primitive type
			PrimitiveType primitiveType = PrimitiveType.values()[rand.nextInt(PrimitiveType.values().length)];
			// Generate a random position for the primitive shape
			int x = rand.nextInt(width);
			int y = rand.nextInt(height);

			g2d.setColor(primitiveColor);

			switch (primitiveType) {
			case LINE:
				drawRandomLine(g2d, x, y, width, height, maxLineWidth);
				break;
			case RECTANGLE:
				drawRandomRectangle(g2d, x, y, maxRectSize);
				break;
			case OVAL:
				drawRandomOval(g2d, x, y, maxOvalSize);
				break;
			case POLYGON:
				drawRandomPolygon(g2d, 6, width, height); // 6 vertices max for the polygon
				break;
			}
		}

		// Save the image to the specified file path
		File output = new File(path);
		ImageIO.write(image, "png", output);

		// Clean up resources
		g2d.dispose();
	}

	private static void drawRandomLine(Graphics2D g2d, int x, int y, int width, int height, int maxLineWidth) {
		int lineWidth = rand.nextInt(maxLineWidth) + 1;
		int x2 = rand.nextInt(width);
		int y2 = rand.nextInt(height);
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.drawLine(x, y, x2, y2);
	}

	private static void drawRandomRectangle(Graphics2D g2d, int x, int y, int maxRectSize) {
		int rectWidth = rand.nextInt(maxRectSize) + 1;
		int rectHeight = rand.nextInt(maxRectSize) + 1;
		g2d.drawRect(x, y, rectWidth, rectHeight);
	}

	private static void drawRandomOval(Graphics2D g2d, int x, int y, int maxOvalSize) {
		int ovalWidth = rand.nextInt(maxOvalSize) + 1;
		int ovalHeight = rand.nextInt(maxOvalSize) + 1;
		g2d.drawOval(x, y, ovalWidth, ovalHeight);
	}

	private static void drawRandomPolygon(Graphics2D g2d, int maxVertices, int maxWidth, int maxHeight) {
		int numVertices = rand.nextInt(maxVertices) + 3; // Minimum 3 vertices for a polygon
		int[] xPoints = new int[numVertices];
		int[] yPoints = new int[numVertices];

		for (int i = 0; i < numVertices; i++) {
			xPoints[i] = rand.nextInt(maxWidth);
			yPoints[i] = rand.nextInt(maxHeight);
		}

		g2d.drawPolygon(xPoints, yPoints, numVertices);
	}

}

package es.usj.pcuesta.imagelibrary.main.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * This class is responsible for generating a random folder hierarchy based on
 * specified parameters. It creates folders with names representing years within
 * a given range and organizes them in a hierarchical structure. The number of
 * folders per level and the maximum number of levels can be configured.
 * 
 * The generated folder hierarchy can be used, for example, to store images in a
 * structured manner.
 * 
 * Author: Pablo Cuesta Morer Date: 2023-05-01
 */
public class RandomFolderGenerator {
	private int maxFoldersPerLevel;
	private int maxLevels;
	private int startYear;
	private int endYear;
	private Random random;

	/**
	 * Constructs a RandomFolderGenerator with the specified parameters.
	 *
	 * @param maxFoldersPerLevel the maximum number of folders per level
	 * @param maxLevels          the maximum number of levels in the folder
	 *                           hierarchy
	 * @param startYear          the starting year of the range
	 * @param endYear            the ending year of the range
	 */
	public RandomFolderGenerator(int maxFoldersPerLevel, int maxLevels, int startYear, int endYear) {
		this.maxFoldersPerLevel = maxFoldersPerLevel;
		this.maxLevels = maxLevels;
		this.startYear = startYear;
		this.endYear = endYear;
		this.random = new Random();
	}

	/**
	 * Generates a random folder hierarchy based on the specified base path. It
	 * creates the folders and returns a list of the created folders.
	 *
	 * @param basePath the base path where the folder hierarchy will be created
	 * @return a list of the created folders
	 */
	public List<File> generateFolders(String basePath) {
		// Create the base directory
		System.out.println("Generating folders at " + basePath + ": ");
		Path path = Paths.get(basePath);

		try {
			if (!Files.exists(path)) {
				// If the directory does not exist, create it
				Files.createDirectory(path);
			} else {
				// If the directory exists, clean it
				Files.walk(path).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
			}
		} catch (IOException e) {
			System.err.println("ERROR: " + e.getMessage());
		}

		// Create the folder hierarchy
		return createFolderHierarchy(basePath, 0);
	}

	private List<File> createFolderHierarchy(String parentPath, int currentLevel) {
		List<File> createdFolders = new ArrayList<>();

		if (currentLevel >= maxLevels) {
			return createdFolders;
		}

		int numberOfFolders = random.nextInt(maxFoldersPerLevel) + 1;

		for (int i = 0; i < numberOfFolders; i++) {
			int year = random.nextInt(startYear, endYear + 1);
			String folderName = String.valueOf(year);
			String folderPath = parentPath + File.separator + folderName;

			File newFolder = new File(folderPath);
			if (!createdFolders.contains(newFolder)) {
				newFolder.mkdirs();
				System.out.println("\t New folder created at: " + newFolder.getAbsolutePath());
				createdFolders.add(newFolder);
				createdFolders.addAll(createFolderHierarchy(folderPath, currentLevel + 1));
			}
		}

		return createdFolders;
	}
}

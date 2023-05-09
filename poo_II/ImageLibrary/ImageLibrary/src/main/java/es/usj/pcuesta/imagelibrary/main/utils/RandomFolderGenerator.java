package es.usj.pcuesta.imagelibrary.main.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-05-01
 */
public class RandomFolderGenerator {
	private int maxFoldersPerLevel;
	private int maxLevels;
	private int startYear;
	private int endYear;
	private Random random;

	public RandomFolderGenerator(int maxFoldersPerLevel, int maxLevels, int startYear, int endYear) {
		this.maxFoldersPerLevel = maxFoldersPerLevel;
		this.maxLevels = maxLevels;
		this.startYear = startYear;
		this.endYear = endYear;
		this.random = new Random();
	}

	/**
	 * 
	 * @param basePath
	 * @return
	 */
	public List<File> generateFolders(String basePath) {
		// Create the base directory
		System.out.println("Generating folders at " + basePath + ": ");
        Path path = Paths.get(basePath);

        try {
        	if (!Files.exists(path)) {
        		// If the dir not exist create it
        		Files.createDirectory(path);
        	} else {
        		// If the dir exist clean it
        		Files.walk(path)
                .sorted(java.util.Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(java.io.File::delete);
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
				System.out.println("\t New folder created at : " + newFolder.getAbsolutePath());
				createdFolders.add(newFolder);
				createdFolders.addAll(createFolderHierarchy(folderPath, currentLevel + 1));
			}
		}

		return createdFolders;
	}
}

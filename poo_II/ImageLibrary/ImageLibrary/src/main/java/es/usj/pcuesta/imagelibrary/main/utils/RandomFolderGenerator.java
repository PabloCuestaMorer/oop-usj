package es.usj.pcuesta.imagelibrary.main.utils;

import java.io.File;
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

	public List<File> generateFolders(String basePath) {
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
				createdFolders.add(newFolder);
				createdFolders.addAll(createFolderHierarchy(folderPath, currentLevel + 1));
			}
		}

		return createdFolders;
	}
}

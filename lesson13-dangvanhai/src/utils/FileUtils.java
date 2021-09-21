package utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import ex01.FileFormat;

public class FileUtils {
	private static Random rd = new Random();

	private FileUtils() {
	}

	public static void createFiles(Path path, int nof, FileFormat[] formats) {
		File dirFolder = new File(path.toString());
		if (!dirFolder.exists()) {
			dirFolder.mkdirs();
		}
		try {
			for (int i = 0; i < nof; i++) {
				createRandomFile(path, formats).createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static File createRandomFile(Path path, FileFormat[] formats) {
		String namePathFile = path + "/" + System.currentTimeMillis()
				+ formats[rd.nextInt(formats.length)].getExtension();
		File newFile = new File(namePathFile);
		while (newFile.exists()) {
			newFile = new File(
					path + "/" + System.currentTimeMillis() + formats[rd.nextInt(formats.length)].getExtension());
		}
		return newFile;
	}

	public static void moveFiles(Path sourceDir, Path targetDir, FileFilter filter) {
		String[] nameFiles = sourceDir.toFile().list();
		for (String name : nameFiles) {
			File file = new File(sourceDir.toString(), name);
			if (filter.accept(file)) {
				moveFile(file, targetDir);
				System.out.println("moved file:" + file.getName());
			}
		}
	}

	public static void moveFile(File file, Path targetDir) {
		try {
			Path newPath = Path.of(targetDir + "/" + file.getName());
			Files.move(file.toPath(), newPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public static void deleteFile(Path pathDir, FileFilter filter) {
		String[] nameFiles = pathDir.toFile().list();
		for (String name : nameFiles) {
			File file = new File(pathDir.toString(), name);
			if (filter.accept(file)) {
				try {
					Files.delete(file.toPath());
					System.out.println("deleted " + file.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static boolean rename(File file, String suffixName) {
		String name = file.getName();
		int index = name.lastIndexOf('.');
		if (index > 0) {
			file.renameTo(new File(file.getParent(), suffixName + "." + name.substring(index + 1)));
			return true;
		}
		return false;
	}
	
	public static String getExtension(File file) {
		int index = file.getName().lastIndexOf('.');
		if(index > 0) {
			return file.getName().substring(index +1);
		}
		return null;
	}

	public static boolean ofFormats(File file, FileFormat[] formats) {
		for (FileFormat format : formats) {
			if (file.getName().endsWith(format.getExtension())) {
				return true;
			}
		}
		return false;
	}

}

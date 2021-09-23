package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import ex01.FileFormat;

public class FileUtils {
	private static Random rd = new Random();

	private FileUtils() {
	}
	
	/**
	 * Create random files base format
	 * 
	 * @param path - Path of directories
	 * @param nof - Number of file
	 * @param formats - List format files
	 */
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
	
	/**
	 * Create a random file
	 * 
	 * @param path - directories path
	 * @param formats - list file formats
	 * @return a newly file be created
	 */
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

	/**
	 * Move all file from source directories to target directories on the condition
	 * 
	 * @param sourceDir - source directories contains file
	 * @param targetDir - target directories contains
	 * @param filter - condition for file moved
	 */
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

	/**
	 * Move a file to target directoriess
	 * 
	 * @param file
	 * @param targetDir
	 */
	public static void moveFile(File file, Path targetDir) {
		try {
			Path newPath = Path.of(targetDir + "/" + file.getName());
			Files.move(file.toPath(), newPath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * Delete all files in directories on the condition
	 * 
	 * @param pathDir
	 * @param filter
	 */
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
	
	/**
	 * Naming the file's suffix name and keep extension file
	 * 
	 * @param file
	 * @param suffixName
	 * @return
	 */
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

	/**
	 * Check file formats
	 * 
	 * @param file
	 * @param formats
	 * @return
	 */
	public static boolean ofFormats(File file, FileFormat[] formats) {
		for (FileFormat format : formats) {
			if (file.getName().endsWith(format.getExtension())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Read a file
	 * @param file
	 * @return array contains text lines of file
	 */
	public static List<String> readFile(File file) {
		List<String> lines = new ArrayList<>();
		FileReader reader = null;
		BufferedReader bufferedReader = null;
		try {
			reader = new FileReader(file);
			bufferedReader = new BufferedReader(reader);
			while(true) {
				String line;
				if((line = bufferedReader.readLine()) == null) {
					break;
				} else {
					lines.add(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(reader, bufferedReader);
		}
		return lines;
	}
	
	/**
	 * Write file
	 * 
	 * @param path
	 * @param lines
	 */
	public static void writeFile(Path path, Collection<?> lines) {
		if(!Files.exists(path, LinkOption.NOFOLLOW_LINKS)) {
			try {
				Files.createFile(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		StringBuilder sequence = new StringBuilder();
		lines.forEach(line -> sequence.append(line).append("\n"));
		try {
			Files.writeString(path, sequence.toString().trim(), StandardOpenOption.WRITE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void close(AutoCloseable... closeables) {
		for(AutoCloseable closeable : closeables) {
			try {
				closeable.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}

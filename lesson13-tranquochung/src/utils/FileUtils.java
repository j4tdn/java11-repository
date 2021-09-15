package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FileUtils {
	private static final Random RD = new Random();

	private FileUtils() {

	}

	public static List<String> readFile(File file) {
		FileReader fr = null;
		BufferedReader br = null;
		List<String> result = new ArrayList<>();

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			line = br.readLine();
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public static boolean[] createMultipleFile(String dirPath, int nof, Extension[] ext) {
		boolean[] result = new boolean[nof];
		int length = ext.length;

		File parent = new File(dirPath);
		if (!parent.exists()) {
			parent.mkdirs();
		}

		for (int i = 0; i < nof; i++) {
			String fileName = "" + System.currentTimeMillis() + ext[RD.nextInt(length)].val();
			File file = new File(parent, fileName);
			result[i] = createFile(file);
		}
		return result;
	}

	public static boolean createFile(File file) {
		boolean isValid = false;
		try {
			isValid = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	public static void copyFile(String source, String target, Extension ext) {
		File sourceFile = new File(source);
		File[] files = sourceFile.listFiles(file -> file.isFile() && file.getName().endsWith(ext.val()));
		for (int i = 0; i < files.length; i++) {
			Path sourcePath = Paths.get(source + "/" + files[i].getName());
			Path targetPath = Paths.get(target + "/" + files[i].getName());
			try {
				Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void moveMultipleExt(String source, String target, Extension... exts) {
		for (Extension ext : exts) {
			moveFile(source, target, ext);
		}
	}

	public static void moveFile(String source, String target, Extension ext) {
		File sourceFile = new File(source);
		File[] files = sourceFile.listFiles(file -> file.isFile() && file.getName().endsWith(ext.val()));
		for (int i = 0; i < files.length; i++) {
			Path sourcePath = Paths.get(source + "/" + files[i].getName());
			Path targetPath = Paths.get(target + "/" + files[i].getName());
			try {
				Files.move(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean[] deleteFile(String source, Extension ext) {
		boolean[] result = null;
		File sourceFile = new File(source);
		File[] files = sourceFile.listFiles(file -> file.isFile() && file.getName().endsWith(ext.val()));
		result = new boolean[files.length];
		for (int i = 0; i < files.length; i++) {
			result[i] = files[i].delete();
		}
		return result;
	}
}

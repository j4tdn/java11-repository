package utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import common.Extension;

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
			while ((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(br, fr);
		}

		return result;
	}

	public static <T> void writeFile(File file, List<T> list) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			for (T t : list) {
				bw.write(t.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw, fw);
		}

		open(file);
	}
	
	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void close(AutoCloseable... autoCloseables) {
		for (AutoCloseable autoCloseable : autoCloseables) {
			if (autoCloseable != null) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
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
	
	public static File create(String path) {
		boolean isValid = true;
		File file = new File(path);
		if (!file.exists()) {
			File paFile = file.getParentFile();
			if (paFile != null && !paFile.exists()) {
				paFile.mkdirs();
			}
			isValid = createFile(file);
		}
		return isValid ? file : null;
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
	
	public static boolean createDirectory(String path) {
		boolean isValid = false;
		File dir = new File(path);
		if (!dir.exists()) {
			isValid = dir.mkdirs();
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

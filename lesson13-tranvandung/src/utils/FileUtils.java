package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import common.Extension;

public class FileUtils {

	private static final Random rd = new Random();

	private FileUtils() {
	}

	// create folder
	public static File create(String path) {
		boolean isValid = true;
		File file = new File(path);
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			try {
				file.mkdirs();
				isValid = file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return isValid ? file : null;
	}

	private static boolean createFile(File file) {
		boolean isValid = false;
		try {
			isValid = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	// create random file
	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		int lenght = exts.length;
		for (int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(lenght)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}
		return result;
	}

	// move file
	public static void moveFiles(String pathBefore, String pathAfter, Extension exts) {
		File moveFiles = new File(pathBefore);
		File[] files = moveFiles.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(exts.val());
			}
		});
		for (File file : files) {
			file.renameTo(new File(pathAfter, file.getName()));
		}
	}

	// delete file
	public static void deleteFiles(String path, Extension exts) {
		File fileDelete = new File(path);
		File[] files = fileDelete.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(exts.val());
			}
		});
		for (File file : files) {
			file.delete();
		}
	}

	// copy file
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

	// create files image
	public static boolean[] createFileImages(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		for (int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + rd.nextInt(10) + exts[rd.nextInt(2)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}
		return result;
	}

	// rename file
	public static void renameFiles(String path, Extension exts) {
		File moveFiles = new File(path);
		File[] files = moveFiles.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(exts.val());
			}
		});
		for (int i = 0; i < files.length; i++) {
			files[i].renameTo(new File(path, "" + (i + 1) + exts.val()));
		}
	}

	// create file
	public static File createFile(String path) {
		boolean isValid = true;
		File file = new File(path);
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (parent != null && !parent.exists()) {
				parent.mkdirs();
			}
			isValid = createFile(file);
		}
		return isValid ? file : null;
	}

	// open file
	public static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// close file
	public static void close(AutoCloseable... closeables) {
		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}

package utils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Random;

import common.Extension;

public class FileUtils {

	private static final Random rd = new Random();

	private FileUtils() {

	}

	public static void MoveFiles(String pathBefore, String pathAfter, Extension exts) {
		File beforeFiles = new File(pathBefore);

		File[] afterFiles = beforeFiles.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(exts.val());
			}
		});

		for (File file : afterFiles) {
			file.renameTo(new File(pathAfter, file.getName()));
		}
	}

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

	public static boolean createFile(File file) {
		boolean isValid = false;
		try {
			isValid = file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isValid;
	}

	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

		int length = exts.length;
		for (int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(length)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}
		return result;
	}

	public static void DeleteFiles(String path, Extension exts) {
		File deleteFile = new File(path);

		File[] files = deleteFile.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(exts.val());
			}
		});

		for (File file : files) {
			file.delete();
		}
	}

	public static boolean[] createFileImages(String path, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		File dirFile = new File(path);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}
		for(int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis()+ rd.nextInt(10) + exts[rd.nextInt(2)].val();
			File file = new File(dirFile, name);
			result[i] = createFile(file);
		}
		
		return result;
	}
	
	public static void renameFiles(String path, Extension exts) {
		File renameFile = new File(path);

		File[] files = renameFile.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(exts.val());
			}
		});

		for (File file : files) {
			file.delete();
		}
		
	}


}
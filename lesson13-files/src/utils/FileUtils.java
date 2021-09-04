package utils;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import common.Extension;

public class FileUtils {
	
	private static final Random rd = new Random();
	
	private FileUtils() {
		
	}
	
	public static File create(String path) {
		File file = new File(path);
		boolean isValid = false;
		if (!file.exists()) {
			File parent = file.getParentFile();
			if (!parent.exists()) {
				parent.mkdir();
			}
			isValid = createFile(file);
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

	public static boolean[] create(String dirPath, int nof, Extension[] exts) {
		boolean[] result = new boolean[nof];
		
		File dirFile = new File(dirPath);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		
		int length = exts.length;
		
		for(int i = 0; i < nof; i++) {
			String name = "" + System.currentTimeMillis() + exts[rd.nextInt(length)].val();
			File file = new File(name);
			result[i] = createFile(file);
		}
		
		return result;
	}
}

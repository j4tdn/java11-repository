package exercise02;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Demo2 {

	private static final String path = "image";

	public static void main(String[] args) {
		File dir = new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}

		create(path, 30, Extention2.values());
		File dirfile = new File(path);
		
		File[] jpgFile = dir.listFiles(a -> a.isFile() && a.getName().endsWith(Extention2.JPG.val()));
		File[] pngFile = dir.listFiles(a -> a.isFile() && a.getName().endsWith(Extention2.PNG.val()));
		
		rename(pngFile, Extention2.PNG);
		rename(jpgFile, Extention2.JPG);
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

	public static boolean[] create(String dirpath, int nof, Extention2[] exts) {
		Random rd = new Random();
		boolean[] result = new boolean[nof];
		File dirFile = new File(dirpath);
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

	public static void rename(File[] files, Extention2 e) {

		for (int i = 0; i < files.length; i++) {
			String path = files[i].getParent();
			files[i].renameTo(new File(path, i + e.val()));
		}
	}

}

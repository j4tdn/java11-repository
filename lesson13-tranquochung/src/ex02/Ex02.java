package ex02;

import java.io.File;

import common.Extension;

import static utils.FileUtils.*;

public class Ex02 {
	private static final String PATH = "images";

	public static void main(String[] args) {
		Extension[] musicExtensions = {Extension.jpg, Extension.png};
		boolean[] fileCreated = createMultipleFile(PATH, 30, musicExtensions);
		for (boolean b : fileCreated) {
			System.out.println(b);
		}
		
		File dirfile = new File(PATH);
		File[] jpgFiles = dirfile.listFiles(file -> file.isFile() && file.getName().endsWith(Extension.jpg.val()));
		File[] pngFiles = dirfile.listFiles(file -> file.isFile() && file.getName().endsWith(Extension.png.val()));
		
		renameMultipleFile(Extension.jpg, jpgFiles);
		renameMultipleFile(Extension.png, pngFiles);
	}

	public static void renameMultipleFile(Extension ext, File[] file) {
		for (int i = 0; i < file.length; i++) {
			String path = file[i].getParent();
			file[i].renameTo(new File(path , i + ext.val()));
		}
	}
}

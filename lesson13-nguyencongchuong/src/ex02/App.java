package ex02;

import common.Extension;
import utils.FileUtils;

public class App {
	
	private static final String path = "images";

	
	public static void main(String[] args) {
		
		// Create random 30 files .jpg, .png
		// FileUtils.createFileImages(path, 30, Extension.values());
		
		// rename files png
		FileUtils.renameFiles(path, Extension.png);
		
		// rename files jpg
		FileUtils.renameFiles(path, Extension.jpg);
	}
}

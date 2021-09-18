package ex02;

import java.io.File;

import bean.Extension;
import utils.FileUtils;

public class Ex02 {
	
	private static final String path = "images";
	
	public static void main(String[] args) {
		// Create folder images
		File imagesDir = FileUtils.createDir(path);
		
		// Create random 30 files .jpg, .png
//	    FileUtils.createFileImages(path, 30, Extension.values());
				
		// Rename files png
		FileUtils.rename(imagesDir, Extension.png);
				
		// Rename files jpg
		FileUtils.rename(imagesDir, Extension.jpg);
	}
}

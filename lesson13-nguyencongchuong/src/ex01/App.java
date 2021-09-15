package ex01;

import common.Extension;
import utils.FileUtils;

public class App {
	private static final String path = "garbage";
	private static final String dirPathImage = "garbage/image";
	private static final String dirPathMusic = "garbage/music";
	private static final String dirPathSystem = "garbage/system";
	private static final String dirPathCoding = "garbage/coding";

	public static void main(String[] args) {
		FileUtils.create(dirPathImage);
		FileUtils.create(dirPathMusic);
		FileUtils.create(dirPathSystem);
		FileUtils.create(dirPathCoding);
		
		// Create random 20 files (.png, .jpg, .jpeg, .mp3, .mp4, .bat, .java, .txt) 
		// FileUtils.create(path, 20, Extension.values());
		
		// Move file .png, .jpg, .jpeg -> image
		FileUtils.moveFiles(path, dirPathImage, Extension.png);
		FileUtils.moveFiles(path, dirPathImage, Extension.jpg);
		FileUtils.moveFiles(path, dirPathImage, Extension.jpeg);
		
		// Move file .mp3, .mp4 -> music
		FileUtils.moveFiles(path, dirPathMusic, Extension.mp3);
		FileUtils.moveFiles(path, dirPathMusic, Extension.mp4);
		
		// Move file .bat -> system
		FileUtils.moveFiles(path, dirPathSystem, Extension.bat);
		
		// Move file .java -> coding
		FileUtils.moveFiles(path, dirPathCoding, Extension.java);
		
		// Delete file .txt
		FileUtils.deleteFiles(path, Extension.txt);
			
	}
}

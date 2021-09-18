package ex01;

import java.io.File;
import java.io.FileFilter;

import bean.Extension;
import utils.FileUtils;

public class Ex01 {
	private static final String path = "garbage";
	private static final String dirPathImage = "garbage/image";
	private static final String dirPathMusic = "garbage/music";
	private static final String dirPathSystem = "garbage/system";
	private static final String dirPathCoding = "garbage/coding";

	public static void main(String[] args) {

		// Create folder garbage, image, music, coding
		File garbageDir = FileUtils.createDir(path);
		File imageDir = FileUtils.createDir(dirPathImage);
		File musicDir = FileUtils.createDir(dirPathMusic);
		File systemDir = FileUtils.createDir(dirPathSystem);
		File codingDir = FileUtils.createDir(dirPathCoding);
		
		// Create random 20 files (.png, .jpg, .jpeg, .mp3, .mp4, .bat, .java, .txt)
//		FileUtils.createFile(path, 20, Extension.values());
		
		// Move file .png, .jpg, .jpeg -> image
	 	FileUtils.move(garbageDir, imageDir, Extension.png);
		FileUtils.move(garbageDir, imageDir, Extension.jpg);
		FileUtils.move(garbageDir, imageDir, Extension.jpeg);

		// Move file .mp3, .mp4 -> music
		FileUtils.move(garbageDir, musicDir, Extension.mp3);
		FileUtils.move(garbageDir, musicDir, Extension.mp4);

		// Move file .bat -> system
		FileUtils.move(garbageDir, systemDir, Extension.bat);

		// Copy file .java -> coding
		FileUtils.copy(garbageDir, codingDir, Extension.java);

		// Delete file .txt
		FileUtils.delete(garbageDir, Extension.txt);
	}
}

package bt01;

import utils.FileUtils;
import static utils.FileUtils.*;

import common.Extension;

public class Bt01 {

	private static final String path = "garbage";
	private static final String pathImage = "garbage/image";
	private static final String pathMusic = "garbage/music";
	private static final String pathSystem = "garbage/system";
	private static final String pathCoding = "garbage/coding";

	public static void main(String[] args) {
		// create 20 files
		create(pathImage);
		create(pathMusic);
		create(pathSystem);
		create(pathCoding);
		create(path, 20, Extension.values());

		// Move file .png, .jpg, .jpeg to Image
		moveFiles(path, pathImage, Extension.png);
		moveFiles(path, pathImage, Extension.jpg);
		moveFiles(path, pathImage, Extension.jpeg);

		// Move file .mp3, .mp4 to music
		moveFiles(path, pathMusic, Extension.mp3);
		moveFiles(path, pathMusic, Extension.mp4);

		// Move file .bat to system
		moveFiles(path, pathSystem, Extension.bat);

		// Copy file .java to coding
		copyFile(path, pathCoding, Extension.java);
		moveFiles(path, pathCoding, Extension.java);
		
	
		// Delete file .txt
		deleteFiles(path, Extension.txt);

	}
}

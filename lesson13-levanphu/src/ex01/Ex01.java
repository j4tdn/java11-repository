package ex01;

import extension.Extension;
import utils.FileUtils;

public class Ex01 {
	private static final String path = "garbage";
	private static final String PathImage = "garbage/image";
	private static final String PathMusic = "garbage/music";
	private static final String PathSystem = "garbage/system";
	private static final String PathCoding = "garbage/coding";

	public static void main(String[] args) {
		FileUtils.create(PathImage);
		FileUtils.create(PathMusic);
		FileUtils.create(PathSystem);
		FileUtils.create(PathCoding);
		
		FileUtils.moveFiles(path, PathImage, Extension.png);
		FileUtils.moveFiles(path, PathImage, Extension.jpg);
		FileUtils.moveFiles(path, PathImage, Extension.jpeg);

		FileUtils.moveFiles(path, PathMusic, Extension.mp3);
		FileUtils.moveFiles(path, PathMusic, Extension.mp4);
		
		FileUtils.moveFiles(path, PathSystem, Extension.bat);
		
		FileUtils.moveFiles(path, PathCoding, Extension.java);
		
		FileUtils.deleteFiles(path, Extension.txt);
	}
}
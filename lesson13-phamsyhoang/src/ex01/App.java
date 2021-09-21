package ex01;

import java.io.File;

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
		
		//FileUtils.create(path, 20, Extension.values());
		
		FileUtils.MoveFiles(path, dirPathImage, Extension.png);
		FileUtils.MoveFiles(path, dirPathImage, Extension.jpg);
		FileUtils.MoveFiles(path, dirPathImage, Extension.jpeg);
		
		FileUtils.MoveFiles(path, dirPathMusic, Extension.mp3);
		FileUtils.MoveFiles(path, dirPathMusic, Extension.mp4);
		
		FileUtils.MoveFiles(path, dirPathSystem, Extension.bat);
		
		FileUtils.MoveFiles(path, dirPathCoding, Extension.java);
		
		FileUtils.DeleteFiles(path, Extension.txt);
	}
}

package excise;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


import common.Extension;
import utils.FileUtils;

import static utils.FileUtils.*;

public class Ex01 {
	private static final String path = "garbage";
	private static final String pathImage = "garbage/image";
	private static final String pathMusic = "garbage/music";
	private static final String pathSystem = "garbage/system";
	private static final String pathCoding = "garbage/coding";
	public static void main(String[] args) {
		
		create(pathImage);
		create(pathMusic);
		create(pathSystem );
		
		create(path, 20, Extension.values());
		
		move(path, pathImage, Extension.png);
		move(path, pathImage, Extension.jpg);
		move(path, pathImage, Extension.jpeg);
		
		move(path, pathMusic, Extension.mp3);
		move(path, pathMusic, Extension.mp4);
		
		move(path, pathSystem, Extension.bat);
		
		
		copy(path, pathCoding, Extension.java);
		
		
		delete(path, Extension.txt);
	}
}

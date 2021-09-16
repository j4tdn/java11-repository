package ex01;

import static utils.FileUtils.*;


import common.Extension;

public class Ex01 {

	private static final String PATH = "garbage";
	private static final String IMAGE = "garbage/image";
	private static final String MUSIC = "garbage/music";
	private static final String SYSTEM = "garbage/system";
	private static final String CODING = "garbage/coding";

	public static void main(String[] args) {
		
		createDirectory(PATH);
		createDirectory(IMAGE);
		createDirectory(MUSIC);
		createDirectory(SYSTEM);
		createDirectory(CODING);

		boolean[] fileCreated = createMultipleFile(PATH, 20, Extension.values());
		for (boolean b : fileCreated) {
			System.out.println(b);
		}

		Extension[] musicExts = { Extension.mp3, Extension.mp4 };
		Extension[] imageExts = { Extension.png, Extension.jpg, Extension.jpeg };
		
		moveMultipleExt(PATH, MUSIC, musicExts);
		moveMultipleExt(PATH, IMAGE, imageExts);
		moveFile(PATH, SYSTEM, Extension.bat);

		copyFile(PATH, CODING, Extension.java);
		
		deleteFile(PATH, Extension.txt);
	
		System.out.println("=== Main End ===");
	}

}

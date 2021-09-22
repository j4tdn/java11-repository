package execution;

import static utils.FileUtils.*;

import common.Extension;

public class Ex01 {
	
	private static final String dirPath = "garbage";
	private static final String dirImagePath = "garbage/image";
	private static final String dirMusicPath = "garbage/music";
	private static final String dirSystemPath = "garbage/system";
	private static final String dirCodingPath = "garbage/coding";
	
	public static void main(String[] args) {
		// Create 4 folders “image, music, system, coding” in forder "garbage"
		createFolder(dirImagePath);
		createFolder(dirMusicPath);
		createFolder(dirSystemPath);
		createFolder(dirCodingPath);
		
		// Create 20 files in forder "garbage"
		create(dirPath, 20, Extension.values());
		
		//
	}
}

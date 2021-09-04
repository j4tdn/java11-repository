package manipulation;

import java.io.File;

import utils.FileUtils;

public class Ex01 {
	private static final String path = "data/readme.txt";
	
	public static void main(String[] args) {
		File file = new File(path);
		
		// write file
		FileUtils.read(file);
		
		// read file
	}
}
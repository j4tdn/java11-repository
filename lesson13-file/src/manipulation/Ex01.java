package manipulation;

import java.io.File;

import java.io.IOException;

import utils.FileUtils;

public class Ex01 {
	private static final String path = "data/readme.txt";

	public static void main(String[] args) throws IOException {
		File file = new File(path);
		FileUtils.read(file);


		// write file
		
	}
}

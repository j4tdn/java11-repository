package manipulation;

import java.io.File;

import Utils.FileUtils;

public class Ex01 {
	private static final String PATH = "data/readme.txt";

	public static void main(String[] args) {
		File file = new File(PATH);
		FileUtils.read(file);
	}
}

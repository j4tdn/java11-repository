package manipulation;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import utils.FileUtils;

public class Ex01 {
	private static final String path = "data/readme.txt";
	public static void main(String[] args) throws IOException {
		File file = new File(path);
		FileUtils.read(file);
	}
}

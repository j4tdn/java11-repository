package manipulation;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

import Utils.FileUtils;

public class Ex01 {
	private static final String path = "data/rename.txt";
	public static void main(String[] args) {
		File file = new File(path);
		
		FileUtils.read(file);
		
	}
}

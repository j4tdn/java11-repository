package manipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import utils.FileUtils;

public class Ex01 {
	private static final String path = "data/readme.txt";
	
	public static void main(String[] args) {
		File file = new File(path);
		FileUtils.read(file);
		
		System.out.println("===========^============");
//		FileUtils.open(file);
		// read file
	}
}

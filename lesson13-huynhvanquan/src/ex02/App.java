package ex02;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Pattern;

import utils.FileUtils;

public class App {
	public static void main(String[] args) {
		FileUtils.createFolder("images");
		FileUtils.create("images", 30, Extension02.values());
		renameFiles();
	}
	
	private static void renameFiles() {
		File[] files = new File("images").listFiles();
		int pngCount = 0;
		int jpgCount = 0;
		for (int i = 0; i < files.length; i++) {
			if(files[i].getName().split(Pattern.quote("."))[1].equals("jpg")) {
				File newFile = new File("images/" + files[i].getName().replaceFirst("[0-9]+", ++pngCount + ""));
				files[i].renameTo(newFile);
			}
			if(files[i].getName().split(Pattern.quote("."))[1].equals("png")) {
				File newFile = new File("images/" + files[i].getName().replaceFirst("[0-9]+", ++jpgCount + ""));
				files[i].renameTo(newFile);
			}	
		}
	}

}

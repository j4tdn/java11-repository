package ex01;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

import utils.FileUtils;


public class App {
	public static void main(String[] args) throws IOException {
		initiate();
		manipulateFiles();
	}

	public static void initiate() {
		FileUtils.createFolder("garbage");		
		FileUtils.createFolder(new String[] { "garbage/image", "garbage/music", "garbage/system", "garbage/coding" });		
		FileUtils.create("garbage", 20, Extension01.values());
	}
	
	public static void manipulateFiles() throws IOException {
		File[] files = new File("garbage").listFiles();
		for(File file : files) {
			if (file.isFile()) {
				String ext = file.getName().split(Pattern.quote("."))[1];	
				System.out.println(ext);
				switch(ext) {
				case "png", "jpg", "jpeg":
					Files.move(Paths.get(file.getPath()), Paths.get(file.getPath().replace("garbage\\", "garbage\\image\\")));
					break;
				case "mp3", "mp4":  
					Files.move(Paths.get(file.getPath()), Paths.get(file.getPath().replace("garbage\\", "garbage\\music\\")));
					break;
				case "bat": 
					Files.move(Paths.get(file.getPath()), Paths.get(file.getPath().replace("garbage\\", "garbage\\system\\")));
					break;
				case "java": 
					Files.move(Paths.get(file.getPath()), Paths.get(file.getPath().replace("garbage\\", "garbage\\coding\\")));
					break;
				case "txt": 
					file.delete();
					break;
				default: ;
				}
			}
		}
	}
	
	
}

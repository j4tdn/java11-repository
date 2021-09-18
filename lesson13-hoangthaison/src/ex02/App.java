package ex02;

import java.io.File;

import common.Extension;
import utils.FileUtils;

public class App {
	public static void main(String[] args) {
		Extension[] imageExts = {Extension.jpg, Extension.png};
		FileUtils.create("garbage/image", 30, imageExts);

		File newFile = new File("garbage/image");
		File[] files = newFile.listFiles( p -> p.isFile() && p.getName().endsWith(Extension.jpg.val()));
		int count = 0;
		for(File file: files) {
			
		}
		
	}

}

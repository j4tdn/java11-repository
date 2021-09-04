package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Ex01 {
	//relative path
	//absolute path
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";
	
	public static void main(String[] args) throws IOException {
		//create file
		//File file = new File(path);
		//System.out.println("is success: " + file);
		
		//FileUtils.create(dirPath, 20, Extension.values());
		
		//filter
		File dirFile = new File(dirPath);
		
		File[] list = dirFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(Extension.txt.val());
			}
		});		FileUtils.printf(list);
	}
}

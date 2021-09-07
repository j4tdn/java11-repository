package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import Utils.FileUtils;
import common.Extension;

public class Ex01 {
	//relative path
	//absolute path
	private static final String path = "data/rename.txt";
	private static final String dirPath = "data/random";
	
	public static void main(String[] args) throws IOException {
		//create file 
	//	File file = FileUtils.create(path);
	//	System.out.println("is success: " + file != null);
		
		// FileUtils.create(dirPath, 20, Extension.values());
		
		//filter
		File dirFile = new File(dirPath);
		File[] files = dirFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(Extension.txt.val());
			}
		});
		
		FileUtils.printf(files);
		
	
	}
}

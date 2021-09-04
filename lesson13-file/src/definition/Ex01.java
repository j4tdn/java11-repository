package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Ex01 {
	// relative path
	// absolute path
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";
	
	public static void main(String[] args) throws IOException {
		//create file
		File file = FileUtils.create(path);
		
		System.out.println("isValid: " + (file != null));
		
		int nof = 20;
//		FileUtils.create(dirPath, 20, Extension.values());
		//filter
		File dirFile = new File(dirPath);
		
		File[] files = dirFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return file.isFile() && file.getName().endsWith(Extension.txt.val());
			}
		});
		
		FileUtils.printf(files);
		
//		
//		//create folder
//		
//		File dir = new File("root/sub/JAVA1231");
//		if (!dir.exists()) {
//			isValid = dir.mkdirs();
//		}
//		dir.delete();
//		System.out.println("isDirValid: " + isValid);
	}
}

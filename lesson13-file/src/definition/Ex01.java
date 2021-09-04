package definition;

import java.io.File;
import java.io.IOException;

import common.Extension;
import utils.FileUtils;

public class Ex01 {
	// relative path
	// absolute path
	
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";
	
	public static void main(String[] args) throws IOException {
		// create file
//		File file = FileUtils.create(path);
//		System.out.println("is success :" + (file != null));
		
//		int nof = 20;
//		boolean[] files = FileUtils.create(dirPath, nof, Extension.values());
//		System.out.println("files : " + files);
		
		// filter
		File dirFile = new File(dirPath);
		File[] list =  dirFile.listFiles(file -> file.isFile() &&
				file.getName().endsWith(Extension.txt.val()));
		FileUtils.printf(list);
	}
}

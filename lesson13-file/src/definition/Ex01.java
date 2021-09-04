package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import common.Extension;
import utils.FileUtils;

public class Ex01 {

	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";

	public static void main(String[] args) throws IOException {

//		File file = FileUtils.create(path);
//		System.out.println("is success: " + (file != null));
//
//		int nof = 20;
		//FileUtils.create(dirPath, 20, Extension.values());

		//System.out.println(file);
		
		//filter
		
		boolean[] files = FileUtils.create(dirPath, 20, Extension.values());
		
		File dirFile = new File(dirPath);
		File[] list = dirFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(Extension.txt.val());
			}
		});
		FileUtils.printf(list);

		// create folder
//		File dir = new File("root/sub/JAVA123");
//		if (!dir.exists()) {
//			isValid = dir.mkdirs();
//		}
//		System.out.println(isValid);

	}
}

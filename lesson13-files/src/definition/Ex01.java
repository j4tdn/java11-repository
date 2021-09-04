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
	public static final String dirPath = "data/random.txt";

	public static void main(String[] args) throws IOException {
		// relative path
		// absolute path

		//File file = FileUtils.create(path);
		//System.out.println("is success: " + (file != null));



		// create folder
//		File dir = new File("root/sub/JAVA123");
//		if (!dir.exists()) {
//			isValid = dir.mkdirs();
//		}
//		System.out.println(isValid);
		 boolean[]  files = FileUtils.create(dirPath, 20, Extension.values());
		 System.out.println(files);
		 
		 File dirFile = new File(dirPath);
		 File[] list = dirFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.isFile() && pathname.getName().endsWith(Extension.txt.val());
			}
		});
		 FileUtils.printf(list);

	}
}
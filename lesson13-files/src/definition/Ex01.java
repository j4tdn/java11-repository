package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import common.Extension;
import utils.FileUtils;

public class Ex01 {
	// relative path: "data.txt"
	// absolute path: "D:\\data.txt"
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";
	
	public static void main(String[] args) throws IOException {
		// Create file 
		File file = FileUtils.create(path);
		System.out.println("is success: " + (file != null));
		Path pth = Paths.get("data", "markup.txt");
		Path pr = Files.createFile(pth);
		System.out.println("pr: " + pr);
		
		// Create folder 
		File dir = new File("root/sub/JAVA123");
		boolean isValid = true;
		if (!dir.exists()) {
			isValid = dir.delete();
			// isValid = dir.mkdirs();
		}
		System.out.println("isDirValid: " + isValid);	
		boolean[] files = FileUtils.create(dirPath, 20, Extension.values());
		System.out.println(files);
		
		// filter
		File dirFile = new File(dirPath);
		File[] fileList = dirFile.listFiles();
		FileUtils.printf(fileList);
		
		File[] filess = dirFile.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isDirectory() && file.getName().endsWith(Extension.txt.val());
			}
				
		});
		FileUtils.printf(filess);
		
		// Other filter
		new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				File file = new File("path");
				return false;
			}
			
		};
		
	}
}

package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.AcceptPendingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import common.Extension;
import utils.FileUtils;

public class Ex01 {
	// relative path
	// absolute path
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";

	public static void main(String[] args) throws IOException {
		File file = FileUtils.create(path);
		System.out.println("is success: " + (file != null));
	
		File dirFile = new File(dirPath);
		File[] files = dirFile.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				
				return file.isFile() && file.getName().endsWith(Extension.txt.val());
			}
		});
		
		FileUtils.printf(files);;
	}
}

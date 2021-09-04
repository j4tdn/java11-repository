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
	// relative path
	// absolute path
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/readme.txt";

	public static void main(String[] args) throws IOException {
		// File files = FileUtils.create(path);

		// System.out.println("Is success: " + (files != null) );

		// boolean[] file = FileUtils.create(dirPath,20,Extension.values());
		// System.out.println(files);

		// filer
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

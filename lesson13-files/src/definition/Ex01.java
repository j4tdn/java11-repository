package definition;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import Utils.FileUtils;
import common.Extension;

public class Ex01 {
	private static final String PATH = "data/readme.txt";
	private static final String dirPath = "data/random";

	public static void main(String[] args) throws IOException {
		// create file
		File file = FileUtils.create(PATH);
		System.out.println("is success: " + (file != null));
		// boolean[] files = FileUtils.create(dirPath, 20, Extension.values());
		File dirFile = new File(dirPath);
		File[] list = dirFile.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(Extension.txt.value());
			}
		});
		FileUtils.print(list);

	}
}

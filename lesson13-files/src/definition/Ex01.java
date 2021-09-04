package definition;

import java.io.File;
import java.io.FileFilter;

import common.Extension;
import utils.FileUtils;

public class Ex01 {
	// relative path
	// absolute path
	private static final String PATH = "data/readme.txt";
	private static final String DIRPATH = "data/random";
	
	public static void main(String[] args) {
		// File file = FileUtils.create(PATH);
		// System.out.println("isFileValid: " + (file != null));
		
		/* Function of Java create file
		 * Path pth = Paths.get("data", "");
		 * Path pr = Files.createFile(pth);
		 * System.out.println("pr: " + pr);
		 */
		
		// boolean[] files = FileUtils.create(DIRPATH, 20, Extension.values());
		
		// filter
		File dirFile = new File(DIRPATH);
		File[] files = dirFile.listFiles(new FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(Extension.txt.val());
			}
			
		});
		FileUtils.printf(files);
	}
}

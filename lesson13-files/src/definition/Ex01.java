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
	// relative path (đường dẫn tương đối) -> không biết nằm ở folder nào
	// absolute path (đường dẫn tuyệt đối) -> chứa link dẫn đến file
	private static final String path = "data/readme.txt";
	private static final String dirPath = "data/random";

	public static void main(String[] args) throws IOException {
		/*
		 * // create file // C1: File file = FileUtils.create(path);
		 * System.out.println("is success: " + (file != null)); // C2: Path pth =
		 * Paths.get("data", "markup.txt"); // với điều kiện folder cha "data" phải tồn
		 * tại Path pr = Files.createFile(pth); System.out.println("pr: " + pr);
		 */

		// FileUtils.create(dirPath, 20, Extension.values());

		// filter
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

package excise;

import static utils.FileUtils.*;

import java.io.File;
import java.io.FileFilter;

import common.Extension2;

public class Ex02 {
	private static final String path = "images";

	public static void main(String[] args) {
		File dir = new File(path);
		create(path, 30, Extension2.values());
		File[] jpg = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {

				return pathname.isFile() && pathname.getName().endsWith(Extension2.jpg.val());
			}
		});

		File[] png = dir.listFiles(new FileFilter() {

			@Override
			public boolean accept(File pathname) {

				return pathname.isFile() && pathname.getName().endsWith(Extension2.jpg.val());
			}
		});
		rename(jpg, Extension2.jpg);
		rename(png, Extension2.png);
	}
}

package ex02;
import extension.Extension;
import utils.FileUtils;

public class Ex02 {
	
	private static final String path = "images";

	
	public static void main(String[] args) {
		FileUtils.renameFiles(path, Extension.png);
		FileUtils.renameFiles(path, Extension.jpg);
	}
}

package definition;

import java.io.File;
import java.io.IOException;

public class Ex02 {
	private static final String PATH = "../data/readme.txt";
	public static void main(String[] args) throws IOException {
		File file = new File(PATH);
		String path = file.getPath();
		String absolutePath = file.getAbsolutePath();
		String canonicalPath = file.getCanonicalPath();
		System.out.println("path: "+path);
		System.out.println("absolutepath: "+absolutePath);
		System.out.println("canonicalPath: "+canonicalPath);
	}
}

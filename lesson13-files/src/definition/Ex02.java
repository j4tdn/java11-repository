package definition;

import java.io.File;
import java.io.IOException;

public class Ex02 {
	private static final String path = "../data/readme.txt";
	public static void main(String[] args) throws IOException{
		File file = new File(path);
		
		String path = file.getPath();
		String asolutePath = file.getAbsolutePath();
		String canonicalPath = file.getCanonicalPath();
		
		System.out.println(path);
		System.out.println(asolutePath);
		System.out.println(canonicalPath);
		
	}
}

package demo;

import java.io.File;
import java.io.IOException;

public class Ex04 {
	public static void main(String[] args) {
		System.out.println("Main start");
		
		// throws CompileException >> handle exception
		File file = new File("excepton.info");
		try {
			// IOException
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main end");
	}
}

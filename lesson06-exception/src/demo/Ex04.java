package demo;

import java.io.File;
import java.io.IOException;

public class Ex04 {
	public static void main(String[] args) {
		System.out.println("start");
		File file = new File("Exception.info");
		try {
			//IOException
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}
}

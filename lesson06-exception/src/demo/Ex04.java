package demo;

import java.io.File;
import java.io.IOException;

public class Ex04 {
	public static void main(String[] args)  {
		File file = new File("exception.info");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package exception.runtime;

import java.io.File;
import java.io.IOException;

public class Ex01 {
	private static final String PATH = "database.md";
	public static void main(String[] args) {
		File file = new File(PATH);
		boolean status =false;
		if(!file.exists())
		{
			try {
				status =file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace() ;
			}
		}
		System.out.println("Status: "+status);
	}
}

package demo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex05 {
	private static final String path = "database.md";
	public static void main(String[] args) {
		//write data into file
		File file = new File(path);
		FileWriter fw = null;
		
		if (file.exists()) {
			try {
				fw = new FileWriter(file);
				fw.write("Line 1\n");
				fw.write("Line 2\n");
				fw.write("Line 3\n");
				
				fw.write(calculation());
				
				fw.write("Line 4\n");
				fw.write("Line 5\n");
				//close and save
				System.out.println("write file successfully");
			} catch (IOException | ArithmeticException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Write successfully");
				open(file);
				
				try {
					fw.close();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
	
	private static int calculation() {
		return 5/0;
	}
	
	private static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

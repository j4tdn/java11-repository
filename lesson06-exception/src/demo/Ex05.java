package demo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex05 {
	private static final String path = "database.md";
	
	public static void main(String[] args) {
		// write data into file
		File file = new File(path);
		
		FileWriter fw = null;
		if(file.exists()) {
			try {
				fw = new FileWriter(file);
				fw.write("Line1\n");
				fw.write("Line2\n");
				fw.write("Line3\n");
				fw.write("Line4\n");
				fw.write("Line5\n");
				fw.write("Line...\n");
				fw.write("Line800\n");
				
				// cup dien
				// du lieu tinh toan sai => exception
				fw.write(calculation());
				
				fw.write("Line...\n");
				fw.write("Line...\n");
				fw.write("Line...\n");
				fw.write("Line999\n");
				
				return;
				
			} catch (IOException | ArithmeticException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Write file sucessfully !!!");
				open(file);

				// close connection & save
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("======== After return =========");
		}
		System.out.println("Main end");
	}
	
	private static int calculation() {
		return 5 / 0;
	}
	
	private static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

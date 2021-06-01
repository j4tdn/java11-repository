package demo;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex05 {
	private static final String path = "database.md";

	public static void main(String[] args) {
		// Write data into file
		File file = new File(path);
		FileWriter fileWriter = null;
		if (file.exists()) {
			try {
				fileWriter = new FileWriter(file);
				fileWriter.write("Line 1\n");
				fileWriter.write("Line 2\n");
				fileWriter.write("Line 3\n");
				fileWriter.write("Line 4\n");
				fileWriter.write("Line 5\n");
				fileWriter.write("Line ...");

				// Exception
				fileWriter.write(cal());

				fileWriter.write("Line ...");
				fileWriter.write("Line 99\n");
				fileWriter.write("Line 100\n");

				System.out.println("return;");
				return;
			} catch (IOException | ArithmeticException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Write file sucessfully !!!");
				open(file);
				
				// close connection & save
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("Main end");
	}

	private static int cal() {
		return 5 / 0;
	}
	
	private static void open(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

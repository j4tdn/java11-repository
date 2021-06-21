package exception.complie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02 {
	private static final String PATH = "database.md";

	public static void main(String[] args) {
		// access file
		File file = new File(PATH);
		if (file.exists()) {
			// write data into file
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				// \n = break line
				// eg: 1000 orders
				fw.write("Line 1\n");
				fw.write("Line 2\n");
				fw.write("Line 3\n");
				fw.write("Line 4\n");
				fw.write("Line 5\n");
				fw.write("Line ========================\n");
				fw.write("Line 770\n");

				fw.write(5 / 0); // calculation => Exception

				fw.write("Line 999\n");
				fw.write("Line 1000\n");

			} catch (ArithmeticException | IOException e) {
				e.printStackTrace();
			} finally {
				System.out.println("Complete wrting data into file " + file.getName());
				// save and close
				try {
					fw.close();
				} catch (IOException e) {
				
					e.printStackTrace();
				}
			}

			System.out.println("-- Thread main --");
		}
	}
}

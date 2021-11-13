package exception.runtime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ex02 {
	private static final String PATH = "database.md";

	public static void main(String[] args) {
		File file = new File(PATH);
		if (file.exists()) {
			FileWriter fw = null;
			try {
				fw = new FileWriter(file);
				fw.write("Line 1\n");
				fw.write("Line 2\n");
				fw.write("Line 3\n");
				fw.write("Line 4\n");
				fw.write("Line 5\n");
				fw.write("Line ==================\n");
				fw.write("Line 770\n");
				fw.write(5 / 0);
			} catch (ArithmeticException | IOException e) {
				System.out.println("ArithemeticException");
			} finally {
				System.out.println("Complete writing data into file " + file.getName());
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("--- Thread main ---");
		}
	}
}

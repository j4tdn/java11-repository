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
		if (file.exists()) {
			try {
				fw = new FileWriter(file);
				fw.write("Line 1\n");
				fw.write("Line 2\n");
				fw.write("Line 3\n");
				fw.write("Line 4\n");
				fw.write("Line 5\n");
				fw.write("Line ...\n");
				fw.write("Line 800\n");

				// cúp điện
				// dữ liệu tính toán sai => exception
				// fw.write(calculation());

				fw.write("Line ...\n");
				fw.write("Line ...\n");
				fw.write("Line ...\n");
				fw.write("Line 999\n");
				
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
			
			System.out.println("=== After return ===");

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

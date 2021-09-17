package exercise04;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Demo4 {
	private static final String path = "readme.txt";

	public static void main(String[] args) {
		int n = 4;
		int m = 5;
		int[][] digits = new int[n][m];

		// write file
		File file = new File(path);
		Random rd = new Random();
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);

			bw.write("rows:" + n + " || cols: " + m + "\n");

			for (int i = 0; i < digits.length; i++) {
				for (int j = 0; j < digits[i].length; j++) {
					digits[i][j] = rd.nextInt(10);
					bw.write(digits[i][j] + "  ");
				}
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw, fw);
		}
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// read file output
		System.out.println("=========================");
		int[][] nums = outputData(file);
		
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				System.out.print(nums[i][j] + "  ");
			}
			System.out.println();
		}

	}

	public static void close(AutoCloseable... closeables) {

		for (AutoCloseable closeable : closeables) {
			if (closeable != null) {
				try {
					closeable.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static int[][] outputData(File file) {
		FileReader fr = null;
		BufferedReader br = null;
		List<String> lines = new ArrayList<>();

		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(br, fr);
		}
		int n = lines.size() - 1;
		int m = lines.get(1).trim().split("\\s+").length;

		int[][] result = new int[n][m];
		for (int i = 1; i < n; i++) {
			String[] s = lines.get(i).split("\\s+");
			
			for (int j = 0; j < m; j++) {
				result[i][j] = Integer.parseInt(s[j]);
			}
		}

		return result;

	}
}

package exam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.Scanner;

import utils.FileUtils;

public class Ex04 {
	private static final String path = "readme.txt";
	private static Random rd = new Random();
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		// create file readme.txt
//		FileUtils.create(path);

		System.out.println("Nhap n : ");
		int n = ip.nextInt();
		System.out.println("Nhap m : ");
		int m = ip.nextInt();

		int[][] array = new int[n][m];

		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				array[row][col] = rd.nextInt(10);
			}
		}

		printf(array);

		File file = new File(path);
		try {
			writeFiles(file, array);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private static void printf(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int col = 0; col < array[row].length; col++) {
				System.out.print(array[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static void writeFiles(File file, int[][] array) throws IOException {
		BufferedWriter outputWriter = null;
		outputWriter = new BufferedWriter(new FileWriter(file.getName()));
		int n = array.length;
		int m = array[0].length;
		
		outputWriter.write(n + "||" + m);
		
		for (int row = 0; row < array.length; row++) {
			outputWriter.newLine();
			for (int col = 0; col < array[row].length; col++) {
				outputWriter.write(array[row][col] + " ");
			}
		}
		outputWriter.flush();
		outputWriter.close();
	}

}

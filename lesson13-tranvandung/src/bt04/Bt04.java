package bt04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import utils.FileUtils;

public class Bt04 {
	private static final String path = "readme.txt";

	public static void main(String[] args) {

		File file = new File(path);
		// write file
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			Scanner ip = new Scanner(System.in);
			Random rd = new Random();
			
			System.out.print("Enter Row:");
			int n = ip.nextInt();
			System.out.print("Enter Col:");
			int m = ip.nextInt();
			int[][] array = new int[n][m];
			
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			bw.write("row: " + n + " || col: " + m + "\n");
			//random value of array
			
			for (int row = 0; row < array.length; row++) {
				for (int col = 0; col < array[row].length; col++) {
					array[row][col] = rd.nextInt(10);
					System.out.print(array[row][col] + " ");
					bw.write(array[row][col] + " ");		
				}
				System.out.println();
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			FileUtils.close(bw, fw);
		}
		System.out.println("Successfully!!!");
		FileUtils.open(file);
	}
}

package ex04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		inputData();
		outputData();
	}
	private static void inputData() {
		int m, n;
		int[][] nums;
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter m, n: ");
		FileWriter fw;
		PrintWriter pw;
		try {
			fw = new FileWriter("data/readme.txt", true);
			pw = new PrintWriter(fw);
			m = sc.nextInt();
			n = sc.nextInt();
			nums = new int[m][n];
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					nums[i][j] = rd.nextInt(10);
					pw.write(nums[i][j] + " ");
				}
				pw.write("\n");
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void outputData() {
		try {
			List<String> lines = Files.readAllLines(Paths.get("data/readme.txt"));
			int m, n;
			int[][] nums;
			m = lines.size();
			n = lines.get(0).trim().split(" ").length;
			nums = new int[m][n];
			for(int i = 0; i < m; i++) {
				String[] s = lines.get(i).trim().split(" ");
				for (int j = 0; j < n; j++) {
					nums[i][j] = Integer.parseInt(s[j]);
					System.out.print(nums[i][j] + " ");
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

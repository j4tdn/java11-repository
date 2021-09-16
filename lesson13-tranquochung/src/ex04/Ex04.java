package ex04;

import static utils.FileUtils.close;
import static utils.FileUtils.create;
import static utils.FileUtils.open;
import static utils.FileUtils.readFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex04 {
	private static final Random RD = new Random();
	private static final String PATH = "readme.txt";
	static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("=== Enter Row ===");
		int row = input();
		System.out.println("===Enter Colum ===");
		int col = input();
		int[][] array = new int[row][col];

		// Random array
		for (int ro = 0; ro < row; ro++) {
			for (int co = 0; co < col; co++) {
				array[ro][co] = RD.nextInt(10);
			}
		}

		File file = create(PATH);
		inputData(file, array);
		outputData(file);

		System.out.println("=== End ===");
	}

	private static void outputData(File file) {
		List<String> lines = readFile(file);
		for (int i = 1; i < lines.size(); i++) {
			String[] items = lines.get(i).split("\\s+");
			List<Integer> list = Arrays.stream(items)
					.filter(item -> !item.isEmpty())
					.map(Integer::parseInt)
					.collect(Collectors.toList());
			for (int number : list) {
				System.out.print(number + " ");
			}
			System.out.println("");
		}
	}

	private static void inputData(File file, int[][] array) {
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			bw.write("row: " + array.length + " || " + array[0].length);
			for (int row = 0; row < array.length; row++) {
				String str = "";
				for (int col = 0; col < array[row].length; col++) {
					str += array[row][col] + " ";
				}
				bw.newLine();
				bw.write(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(bw, fw);
		}
		open(file);
	}

	private static int input() {
		int tmp = 0;
		while (true) {
			try {
				System.out.print("Enter Number = ");
				tmp = Integer.parseInt(ip.nextLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Must be Number!!");
			}
		}
		return tmp;
	}
}

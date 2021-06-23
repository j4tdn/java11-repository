package ex;

import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		String line = "12 34 567 89 101 112 13 14 1 3 5 6 4 8 5  4 2 54564";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter position: ");
		int i = scanner.nextInt();
		scanner.close();
		System.out.println("Result: " + line.split(" ")[i - 1]);
	}
}

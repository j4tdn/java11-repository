package ex3;

import java.util.Scanner;

public class Ex3App {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n: ");
		n = sc.nextInt();
		int[] numList = new int[n + 2];
		numList[0] = 1;

		System.out.println("=====");
		for (int i = 0; i < n + 1; i++) {
			// Process
			for (int j = n + 2 - 1; j >= 1; j--) {
				numList[j] = numList[j] + numList[j - 1];
			}

			// Print
			for (int j = 0; j < n + 2; j++) {
				if (numList[j] == 0) {
					break;
				}
				System.out.print(numList[j]);
				printSpace("    ".length() - String.valueOf(numList[j]).length());
			}
			System.out.println();
		}

	}

	private static void printSpace(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
	}
}

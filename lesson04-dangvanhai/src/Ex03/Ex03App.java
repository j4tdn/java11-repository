package Ex03;

import java.util.Scanner;

public class Ex03App {
	public static void main(String[] args) {
		int[][] array;
		Scanner scanner = new Scanner(System.in);

		// Get n from typing
		System.out.print("Nhap n: ");
		int n = scanner.nextInt();
		scanner.close();

		// Initial array 2d and set default value for root row
		array = new int[n + 1][n + 2];
		array[0][0] = 1;
		array[0][1] = 1;

		// Fill value and print the triangle Pascal
		fill(array);
		print(array);
	}

	private static void fill(int[][] a) {
		for (int i = 1; i < a.length; i++) {
			a[i][0] = 1;
			for (int j = 1; j < a[i].length; j++) {
				if (a[i - 1][j] != 0) {
					a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
				} else {
					a[i][j] = 1;
					break;
				}
			}
		}
	}

	private static void print(int[][] a) {
		System.out.println("\n-- Tam Giac Pascal --\n");
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] != 0 ? String.format("%-3s", a[i][j]) + " " : "");
			}
			System.out.println();
		}
	}
}

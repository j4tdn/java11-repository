package ex03;

import java.util.Scanner;

public class Ex03Main {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n = ");
		int n = ip.nextInt();
		tgPascal(n);
	}

	private static void tgPascal(int n) {
		int[][] a = new int[n][n];
		int row, col;
		for (row = 0; row < n; row++) {
			a[row][0] = 1;
			for (col = 1; col <= row; col++) {
				a[row][col] = a[row - 1][col - 1] + a[row - 1][col];
			}
		}
		for (row = 0; row < n; row++) {
			for (col = 0; col <= row; col++) {
				System.out.print(a[row][col] + "\t");
			}
			System.out.println();

		}

	}
}

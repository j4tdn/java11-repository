package bai03;

import java.util.Scanner;

public class TamGiacPascal {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = ip.nextInt();
		sapXep(n);
	}

	public static void sapXep(int n) {
		int[][] a = new int[n][n];

		for (int x = 0; x < n; x++) {
			a[x][0] = 1;
			for (int y = 1; y <= x; y++) {
				a[x][y] = a[x - 1][y - 1] + a[x - 1][y];
			}
		}
		for (int x = 0; x < n; x++) {
			for (int y = 0; y <= x; y++) {
				System.out.print(a[x][y] + " ");
			}
			System.out.println();
		}
	}

}

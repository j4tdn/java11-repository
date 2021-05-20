package view;

import java.util.Scanner;

public class Ex03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap n: ");
		int n = Integer.parseInt(sc.nextLine());
		int[][] array = new int[n + 1][n + 2];
		array[0][0] = 1;
		array[0][1] = 1;

		trianglePascal(array);
		print(array);
	}

	private static void trianglePascal(int[][] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (j == 0) {
					a[i][j] = 1;
					continue;
				}
				if (i + 1 == j) {
					a[i][j] = 1;
					break;
				}
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
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

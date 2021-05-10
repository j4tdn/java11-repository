package demo;

import java.util.Scanner;

public class Ex03 {
	static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhap m : ");
		int M = ip.nextInt();
		System.out.print("Nhap n : ");
		int N = ip.nextInt();
		int[][] a = new int[M][N];
		input(a, M, N);
		view(a, M, N);
		if (yenNgua(a, M, N) == 1) {
			System.out.println("Khong co diem yen ngua ");
		} else {
			System.out.println("Phan tu yen ngua la : " + yenNgua(a, M, N));
		}
	}

	private static void input(int a[][], int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("Nhap phan tu [" + i + " , " + j + "] = ");
				a[i][j] = ip.nextInt();
			}
		}
	}

	private static void view(int a[][], int m, int n) {
		System.out.println("Mang vua nhap : ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("\t" + a[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * 47 47 36 23 43 31 46 07 29
	 */
	public static int yenNgua(int a[][], int row, int col) {
		int min;
		int max;
		int n = 0;
		for (int i = 0; i < row; i++) {
			min = a[i][0];

			// min row
			for (int j = 0; j < col; j++) {
				if (min > a[i][j]) {
					min = a[i][j];
					n = j;
				}
			}
			max = min;
			// max col
			for (int z = 0; z < row; z++) {
				if (max < a[z][n]) {
					max = a[z][n];
				}
			}
			if (max == min) {
				return max;
			}
		}
		return 1;
	}
}

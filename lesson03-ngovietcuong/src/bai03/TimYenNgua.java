package bai03;

import java.util.Random;
import java.util.Scanner;

public class TimYenNgua {
	// yên ngựa là nhỏ nhất trong hàng , lớn nhất trong cột

	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap so hang: ");
		int x = ip.nextInt();
		System.out.print("Nhap so cot: ");
		int y = ip.nextInt();

		int[][] A = new int[x][y];
		System.out.println("\nNhap ma tran");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("A[" + i + "][" + j + "] = ");
				A[i][j] = ip.nextInt();
			}
		}
		System.out.println("\nXuat ma tran");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println("\n");
		}

		if (yenNgua(A, x, y) == 0)
			System.out.println("Khong co so yen ngua");
		else
			System.out.println("So yen ngua la: " + yenNgua(A, x, y));

	}

	public static int yenNgua(int[][] A, int x, int y) {
		int min;
		int max;
		int z = 0;
		for (int i = 0; i < x; i++) {
			min = A[i][0];
			for (int j = 0; j < y; j++) {
				if (min > A[i][j]) {
					min = A[i][j];
					z = j;
				}
			}
			max = min;
			for (int k = 0; k < x; k++) {
				if (max < A[k][z])
					max = A[k][z];
			}
			if (min == max)
				return min;
		}
		return 0;
	}
}

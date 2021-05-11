package baitap13;

import java.util.Scanner;

public class Bt03 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap so hang cua mang: ");
		int M = ip.nextInt();
		System.out.print("Nhap so cot cua mang : ");
		int N = ip.nextInt();
		int[][] A = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print("Nhap A[" + i + "]" + "[" + j + "]: ");
				A[i][j] = ip.nextInt();
				while (A[i][j] < 1 || A[i][j] > 99) {
					System.out.print("Nhap lai A[" + i + "]" + "[" + j + "]: ");
					A[i][j] = ip.nextInt();
				}
			}
			System.out.println();
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}

		int colum = 0;
		for (int i = 0; i < A.length; i++) {
			int row = i;
			int min = A[i][0];
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] < min) {
					min = A[i][j];
					colum = j;
				}
			}

			boolean isMax = true;
			for (int r = 0; r < A.length; r++) {
				if (A[r][colum] > min) {
					isMax = false;
					break;
				}
			}
			if (isMax)
				System.out.println("phan tu yen ngua la :" + "A[" + row + "]" + "[" + colum + "] = " + A[row][colum]);
		}
	}
}

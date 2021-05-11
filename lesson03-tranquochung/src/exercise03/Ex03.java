package exercise03;

import java.util.Scanner;

public class Ex03 {
	static int n;
	static int m;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Array A[M][N]:");
		System.out.print("Please Enter M = ");
		n = scanner.nextInt();
		System.out.print("Please Enter N = ");
		m = scanner.nextInt();
		int[][] A = new int[m][n];
		//Enter Array A[]
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print("A[" + i + "][" + j + "] = ");
				A[i][j] = scanner.nextInt();
			}
		}
		//Show Array A[]
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		//check
		if(sadleNumber(A) == 0) System.out.println("không có số yên ngựa");
		else System.out.println("Số Yên Ngựa là: " + sadleNumber(A));
	}
	public static int sadleNumber(int A[][]) {
		int min;
		int max;
		int x = 0;
		for(int i = 0 ; i < m ; i++) {
			min = A[i][0];
			for(int j = 0; j < n; j++) {
				if(min > A[i][j]) {
					min = A[i][j];
					x = j;
				}
			}
			max = min;
			for(int k = 0; k < m ;k++) {
				if(max < A[k][x]) max = A[k][x];
			}
			if(min == max) return min;
		}
		return 0;
	}
}

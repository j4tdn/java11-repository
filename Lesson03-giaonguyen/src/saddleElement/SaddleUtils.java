package saddleElement;

import java.util.Scanner;

public class SaddleUtils {

	static int col;
	static int row;
	static int[][] matrix;

	public static void inputMatrix() {

		Scanner sc = new Scanner(System.in);
		System.out.print("Number of row: ");
		row = sc.nextInt();
		System.out.print("Number of col: ");
		col = sc.nextInt();

		matrix = new int[row][col];
		//input matrix
		System.out.println("Input element of matrix:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print("matrix[" + i + "," + j + "] = ");
				matrix[i][j] = sc.nextInt();
			}
		}

		//print matrix
		System.out.println("Matrix: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("\n");
		}
	}

	public static void findSaddleElement(int[][] matrix) {

		boolean check = false;
		int count = 0;
		for (int i = 0; i < row; i++) {
			int col_temp = 0;
			int min = matrix[i][0];
			for (int j = 0; j < col; j++) {
				if (min > matrix[i][j]) {
					min = matrix[i][j];	
					col_temp = j;
					check = true;
				}
			}
			
			if (col_temp == 0) check = true; //fist element is min.

			for (int m = 0; m < row; m++) {
				if (matrix[i][col_temp] < matrix[m][col_temp]) check = false;
			}

			if (check) {
				count++;
				System.out.println("Saddle element is at (" + i + "," + col_temp + ")" + ", value = " + matrix[i][col_temp]);
			}
			check = false;
		}
		if (count == 0) System.out.println("Matrix is not include saddle element.");
	}
}

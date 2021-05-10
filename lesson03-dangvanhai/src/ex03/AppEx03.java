package ex03;

import java.util.Scanner;

/*
 * Find saddle point in matrix 2d
 */
public class AppEx03 {
	private final static int length = 3;
	private final static int rowMatrix = length;
	private final static int columnMatrix = length;
	private static int[][] mat = new int[rowMatrix][columnMatrix];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		inputMatrix();
		MatrixUtils.findSaddlePoint(mat, rowMatrix, columnMatrix);
		if (Result.exist) {
			System.out.println("Saddle point: " + Result.value); // 1 2 3 4 5 6 7 8 9
		} else {
			System.out.println("Not exist saddle point"); // 1 -2 3 -6 5 -4 7 -8 9
		}
	}

	private static void inputMatrix() {
		System.out.println("Nhap ma tran " + rowMatrix + "x" + columnMatrix + ":");
		for (int i = 0; i < rowMatrix; i++) {
			for (int j = 0; j < columnMatrix; j++) {
				mat[i][j] = scanner.nextInt();
			}
		}
		scanner.close();
	}
}

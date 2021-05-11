package exercise;

import java.util.Random;

public class Ex03_saddleElement {
	public static void main(String[] args) {
		int rows = 3;
		int cols = 3;
		int[][] matrix = new int[rows][cols];
		createMatrix(matrix, rows, cols);
		findSaddlePoint(matrix);

	}

	private static int[][] createMatrix(int[][] matrix, int rows, int cols) {

		Random rd = new Random();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = 1 + rd.nextInt(99);
			}
		}

		System.out.println("Matrix : ");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("\n");
		}
		return matrix;
	}

	static void findSaddlePoint(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			int rowMin = matrix[i][0];
			int colIndex = 0;
			boolean saddlePoint = true;

			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] < rowMin) {
					rowMin = matrix[i][j];
					colIndex = j;
				}
			}

			for (int j = 0; j < matrix.length; j++) {
				if (matrix[j][colIndex] > rowMin) {
					saddlePoint = false;
					break;
				}
			}

			if (saddlePoint) {
				System.out.println("Saddle element is : " + rowMin);
				return;
			}
		}
		System.out.println("There is no saddle element");
	}

}

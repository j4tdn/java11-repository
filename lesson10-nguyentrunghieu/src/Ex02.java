import java.util.Scanner;

public class Ex02 {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Nhập số hàng của ma trận: ");
		int row = Integer.parseInt(sc.nextLine());
		System.out.print("Nhập số cột của ma trận : ");
		int col = Integer.parseInt(sc.nextLine());
		System.out.println("===========================");

		int[][] matrix = new int[row][col];
		input(matrix);
		System.out.println("Ma trận vừa nhập:");
		output(matrix);
		System.out.println("===========================");

		System.out.println("Ma trận sau khi chuyển đổi:");
		int[][] advancedMatrixConvers = advancedMatrixConvers(matrix, row, col);
		output(advancedMatrixConvers);
		System.out.println("===========================");
	}

	private static int[][] advancedMatrixConvers(int[][] matrix, int row, int col) {
		int[][] advancedMatrixConvers = copyArray(matrix, row, col);
		int[][] zeroPosition = getTheZeroPosition(advancedMatrixConvers, row, col);
		int count = 0;
		while (count < zeroPosition.length) {
			convers(advancedMatrixConvers, zeroPosition[count][0], zeroPosition[count][1]);
			count++;
		}
		return advancedMatrixConvers;
	}

	private static int[][] getTheZeroPosition(int[][] advancedMatrixConvers, int row, int col) {
		int[][] getTheZeroPosition = new int[row * col][2];
		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (advancedMatrixConvers[i][j] == 0) {
					getTheZeroPosition[count][0] = i;
					getTheZeroPosition[count++][1] = j;
				}
			}
		}
		int[][] zeroPosition = new int[count][2];
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < 2; j++) {
				zeroPosition[i][j] = getTheZeroPosition[i][j];
			}
		}
		return zeroPosition;
	}

	private static void convers(int[][] matrixConvers, int row, int col) {
		for (int i = 0; i < matrixConvers.length; i++) {
			for (int j = 0; j < matrixConvers[row].length; j++) {
				if (i == row || j == col) {
					matrixConvers[i][j] = 0;
				}
			}
		}
	}

	private static int[][] copyArray(int[][] fistArray, int row, int col) {
		int[][] secondArray = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				secondArray[i][j] = fistArray[i][j];
			}
		}
		return secondArray;
	}

	private static void input(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				matrix[row][col] = Integer.parseInt(sc.nextLine());
			}
		}
	}

	private static void output(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}
}


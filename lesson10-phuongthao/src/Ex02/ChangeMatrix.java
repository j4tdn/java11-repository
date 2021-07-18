package Ex02;

public class ChangeMatrix {

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };

		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 0, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };

		changeMatrix(matrix);
		printf(matrix);
	}

	public static void changeMatrix(int[][] matrix) {
		int poitRow = 0;
		int poitCol = 0;

		for (int row = poitRow; row < 4; row++) {
			for (int col = poitCol; col < 4; col++) {
				if (matrix[row][col] == 0) {
					poitRow = row;
					poitCol = col;

				}
			}
		}

		for (int rowc = 0; rowc < 4; rowc++) {
			for (int colc = 0; colc < 4; colc++) {
				if (rowc == poitRow || colc == poitCol) {
					matrix[rowc][colc] = 0;

				}
			}
		}

	}

	private static void printf(int[][] matrix) {
		for (int row = 0; row < 4; row++) {
			for (int col = 0; col < 4; col++) {
				System.out.print(matrix[row][col] + " ");
			}
			System.out.println();
		}
	}

}

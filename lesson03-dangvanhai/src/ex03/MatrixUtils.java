package ex03;

public class MatrixUtils {
	public static void findSaddlePoint(int[][] mat, int rowMatrix, int columnMatrix) {
		for (int i = 0; i < rowMatrix; i++) {

			// Find the minimum element of row i
			// Archive index column of the minimum element
			int valueMinOfRow = mat[i][0];
			int indexMinOfRow = 0;
			for (int j = 0; j < columnMatrix; j++) {
				if (valueMinOfRow > mat[i][j]) {
					valueMinOfRow = mat[i][j];
					indexMinOfRow = j;
				}
			}

			// Find the maximum element of column archived
			int valueMaxOfCol = valueMinOfRow;
			for (int j = 0; j < rowMatrix; j++) {
				if (valueMaxOfCol < mat[j][indexMinOfRow]) {
					break;
				}
				if (j == rowMatrix - 1) {
					Result.exist = true;
					Result.value = valueMaxOfCol;
					return;
				}
			}
		}

		// Not exist saddle point for matrix
		Result.exist = false;
	}
}

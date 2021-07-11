package ex02;

public class Ex02 {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		printMaxtrix(matrix);
		matrixTransformation(matrix);
		
		System.out.println("\n Matrix after transformation:");
		printMaxtrix(matrix);
	}
	
	private static void matrixTransformation(int[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if(matrix[row][column] == 0) {
					for(int rowi = 0; rowi < matrix.length; rowi++) {
						matrix[rowi][column] = 0;
					}
					for(int columni = 0; columni < matrix[row].length; columni++) {
						matrix[row][columni] = 0;
					}
					return;
				}
			}
		}
	}
	
	private static void printMaxtrix(int[][] matrix) {
		for(int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
}

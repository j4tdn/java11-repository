package ex02;

public class Ex02 {
	public static void main(String[] args) {
		int[][] digits = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 8, 7 }, 
				{ 1, 9, 0, 9 }, 
				{ 2, 9, 6, 5 }, 
				{ 1, 2, 4, 5 } 
				};
		print(matrix(digits));
		System.out.println("=================");
		int[][] newDigits = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 0, 8, 7 }, 
				{ 1, 9, 0, 9 }, 
				{ 2, 0, 6, 5 }, 
				{ 1, 2, 4, 5 }, 
				};
		print(matrix(newDigits));
	}

	private static void print(int[][] digits) {
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[row].length; col++) {
				System.out.print(digits[row][col] + " ");
			}
			System.out.println();
		}
	}

	private static void solve(int[][] digits, int pointR, int pointC) {
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[row].length; col++) {
				digits[row][pointC] = 0;
				digits[pointR][col] = 0;
			}
		}
	}

	private static int[][] matrix(int[][] digits) {
		Point[] points = new Point[digits.length * digits[0].length];
		int index = 0;
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[row].length; col++) {
				if (digits[row][col] == 0) {
					points[index++] = new Point(row, col);
				}
			}
		}

		for (Point point : points) {
			if (point == null) {
				break;
			}
			solve(digits, point.getRow(), point.getCol());
		}

		return digits;
	}
}

package ex01;

import static utils.ArrayUtils.*;

public class AppEx01 {
	private static final int n = 4;

	public static void main(String[] args) {
		int[][] arr = draw(n);
		printArray(arr);
	}

	private static int[][] draw(int n) {
		int[][] arr = new int[2 * n - 1][2 * n - 1];
		fill(arr, n - 1, n - 1);
		return arr;
	}

	private static void fill(int[][] arr, int i, int j) {
		// Validate
		if ((i < 0 || i >= arr.length) || (j < 0 || j >= arr[i].length)) {
			return;
		}

		// Fill here and the flip horizontal position
		arr[i][j] = j + 1;
		arr[i][arr.length - 1 - j] = arr.length - j;

		// Fill in the three nearest positions of left
		fill(arr, i - 1, j - 1);
		fill(arr, i, j - 1);
		fill(arr, i + 1, j - 1);
	}
}
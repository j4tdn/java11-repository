package ex01;

import static utils.ArrayUtils.*;

public class AppEx01 {
	enum Direction {
		LEFT, RIGHT, TOP, BOTTOM;
	}

	private static final int n = 4;

	public static void main(String[] args) {
		int[][] arr = draw(n);
		printArray(arr);
	}

	private static int[][] draw(int n) {
		int len = 2 * n - 1;
		int[][] arr = new int[len][len];
		fill(arr, n - 1, n - 1, Direction.LEFT);
		fill(arr, n - 1, n - 1, Direction.RIGHT);
		return arr;
	}

	private static void fill(int[][] arr, int i, int j, Direction direction) {
		// Validate
		if (i < 0 | i >= arr.length) {
			return;
		}
		if (j < 0 | j >= arr[i].length) {
			return;
		}

		// Fill this
		arr[i][j] = j + 1;

		// Fill boxes which near this by direction
		if (direction == Direction.LEFT) {
			fill(arr, i - 1, j - 1, direction);
			fill(arr, i, j - 1, direction);
			fill(arr, i + 1, j - 1, direction);
		} else if (direction == Direction.RIGHT) {
			fill(arr, i - 1, j + 1, direction);
			fill(arr, i, j + 1, direction);
			fill(arr, i + 1, j + 1, direction);
		}
	}
}

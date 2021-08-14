package ex01;

public class Ex01 {

	public static void main(String[] args) {
		int[][] arr = draw(5);
		print(arr);
	}

	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					System.out.print("  ");
				} else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}

	}

	private static int[][] draw(int n) {
		int[][] arr = new int[2 * n - 1][2 * n - 1];
		fill(arr, n - 1, n - 1);
		return arr;
	}

	private static void fill(int[][] arr, int i, int j) {
		if ((i < 0 || i >= arr.length) || (j < 0 || j >= arr[i].length)) {
			return;
		}
		arr[i][j] = j + 1;
		arr[i][arr.length - 1 - j] = arr.length - j;

		fill(arr, i - 1, j - 1);
		fill(arr, i, j - 1);
		fill(arr, i + 1, j - 1);
	}
}

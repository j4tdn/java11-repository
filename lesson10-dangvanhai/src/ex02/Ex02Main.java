package ex02;

import java.util.Arrays;

public class Ex02Main {
	public static void main(String[] args) {
		int[][] arr = new int[][] { 
			{ 1, 2, 3, 4 }, 
			{ 5, 0, 8, 7 }, 
			{ 1, 9, 0, 9 }, 
			{ 2, 0, 6, 5 }, 
			{ 1, 2, 4, 5 } 
		};

		// transform matrix
		transform(arr);

		// print matrix
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	private static void transform(int[][] arr) {
		if (arr.length == 0) {
			return;
		}
		boolean[] rows = new boolean[arr.length];
		boolean[] cols = new boolean[arr[0].length];

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (arr[row][col] == 0) {
					rows[row] = true;
					cols[col] = true;
				}
			}
		}

		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[row].length; col++) {
				if (rows[row] == true || cols[col] == true) {
					arr[row][col] = 0;
				}
			}
		}
	}
}

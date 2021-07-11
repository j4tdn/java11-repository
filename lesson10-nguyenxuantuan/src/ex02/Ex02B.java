package ex02;

import java.util.HashSet;
import java.util.Set;

public class Ex02B {
	public static void main(String[] args) {
		int[][] digits = { { 1, 2, 3, 4 }, { 5, 0, 7, 8 }, { 1, 3, 5, 7 }, { 2, 4, 0, 8 }, { 1, 4, 7, 8} };

		changeMatrix(digits);

	}
	private static void changeMatrix(int[][] digits) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();

		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[0].length; col++) {
				if (digits[row][col] == 0) {
					rows.add(row);
					cols.add(col);
				}
			}
		}
		System.out.println("Mang truoc khi thay doi");
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[0].length; col++) {
				System.out.print(digits[row][col] + "\t");
			}
			System.out.println();
		}


		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[0].length; col++) {
				if (rows.contains(row) || cols.contains(col)) {
					digits[row][col] = 0;
				}
			}
		}
		System.out.println("====================");
		System.out.println("Mang sau khi thay doi");
		for (int row = 0; row < digits.length; row++) {
			for (int col = 0; col < digits[0].length; col++) {
				System.out.print(digits[row][col] + "\t");
			}
			System.out.println();
		}
	}
}

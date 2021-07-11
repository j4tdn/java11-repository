package ex02;

import java.util.Scanner;

public class Ex02 {
	public static void main(String[] args) {
		int[][] Input = { { 1, 2, 3, 4 }, { 5, 6, 8, 7 }, { 1, 9, 0, 9 }, { 2, 9, 6, 5 }, { 1, 2, 4, 5 } };
		System.out.println("Mang truoc khi sap xep");
		printMatrix(Input);
		Transformation(Input);
		System.out.println("Mang sau khi sap xep :");
		printMatrix(Input);
	}

	private static void Transformation(int[][] Input) {
		for (int row = 0; row < Input.length; row++) {
			for (int column = 0; column < Input[row].length; column++) {
				if (Input[row][column] == 0) {
					for (int rowi = 0; rowi < Input.length; rowi++) {
						Input[rowi][column] = 0;
					}
					for (int columni = 0; columni < Input[row].length; columni++) {
						Input[row][columni] = 0;
					}
					return;
				}
			}
		}
	}

	private static void printMatrix(int[][] Input) {
		for (int row = 0; row < Input.length; row++) {
			for (int column = 0; column < Input[row].length; column++) {
				System.out.print(Input[row][column] + " ");
			}
			System.out.println();
		}
	}
}

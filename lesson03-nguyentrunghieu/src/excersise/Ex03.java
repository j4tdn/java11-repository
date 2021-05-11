package excersise;

import java.util.Scanner;

public class Ex03 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int[][] arr = input();
		System.out.println();
		Show(arr);
		System.out.println();
		System.out.println("Phần tử yên ngựa là: " + yenNgua(arr));
	}

	private static int yenNgua(int[][] arr) {
		int y = 0;
		int min = arr[0][0];
		for (int i = 0; i < arr.length; i++) {
			min = arr[i][0];
			for (int j = 0; j < arr[i].length; j++) {
				if (min > arr[i][j]) {
					min = arr[i][j];
					y = j;
				}
			}

			if (isMax(arr, i, y)) {
				return arr[i][y];
			}
		}

		return 0;
	}

	private static boolean isMax(int[][] arr, int i, int j) {

		for (int k = 0; k < arr.length; k++) {
			if (arr[i][j] < arr[k][j]) {
				return false;
			}
		}
		return true;
	}

	public static int[][] input() {
		int x, y;
		System.out.print("Nhap so hang: ");
		x = input.nextInt();
		System.out.print("Nhap so cot: ");
		y = input.nextInt();
		int[][] arr = new int[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print("Nhap phan tu [" + i + " ; " + j + "] = ");
				arr[i][j] = input.nextInt();
			}
		}

		return arr;
	}

	public static void Show(int arr[][]) {
		System.out.println("Hien thi ma tran");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}

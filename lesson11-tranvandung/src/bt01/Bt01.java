package bt01;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter n:");
		int n = ip.nextInt();
		int len = 2 * n - 1;
		int[][] arr = new int[len][len];

		// Print left
		for (int j = 0; j < n; j++) {
			for (int i = j; i < len - j; i++) {
				arr[i][j] = j + 1;
			}
		}
		// Print right
		for (int j = n; j < len; j++) {
			for (int i = len - j - 1; i < j + 1; i++) {
				arr[i][j] = j + 1;
			}
		}

		printArray(arr);
	}

	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] != 0) {
					System.out.print(arr[i][j] + " ");
				} else {
					System.out.print(" " + " ");
				}
			}
			System.out.println();
		}
	}
}
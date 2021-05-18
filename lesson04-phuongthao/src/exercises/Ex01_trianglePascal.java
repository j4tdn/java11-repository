package exercises;

import java.util.Scanner;

public class Ex01_trianglePascal {
	public static void main(String[] args) {
		int h;
		System.out.println("h = ");
		Scanner ip = new Scanner(System.in);
		h = ip.nextInt();
		int[][] arr = new int[h][h];
		Pascal(arr);

	}

	private static void Pascal(int[][] arr) {
		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < i; j++) {
				if (i == j || j == 0) {
					arr[i][j] = 1;
					System.out.print(arr[i][j] + "\t");

				} else {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
					System.out.print(arr[i][j] + "\t");
				}

			}
			System.out.println();
		}

	}
}

package exercise03;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		System.out.print("Enter number: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		trianglePascal(n);
	}

	public static void trianglePascal(int n) {
		int[][] trPascal = new int[n + 1][n + 2];
		for (int i = 0; i <= n; i++) {
			trPascal[i][0] = 1;
		}
		int d = 0;
		trPascal[d][1] = 1;
		for (int j = 1; j <= n + 1; j++) {
			for (int i = 1; i <= n; i++) {
				trPascal[i][j] = trPascal[i - 1][j] + trPascal[i - 1][j - 1];
			}
			d++;
		}

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n + 1; j++) {
				System.out.print("\t" + trPascal[i][j]);
			}
			System.out.println();
		}
	}
}

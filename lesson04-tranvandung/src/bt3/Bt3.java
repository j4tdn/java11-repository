package bt3;

import java.util.Scanner;

public class Bt3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap n = ");
		int n = ip.nextInt() + 2;
		Pascal(n);
	}

	private static void Pascal(int n) {
		int[][] Arr = new int[n][n];
		int C, D;
		System.out.println("Tam giac Pascal la: ");
		for (D = 0; D < n; D++) {
			Arr[D][0] = 1;
			for (C = 1; C <= D; C++) {
				Arr[D][C] = Arr[D - 1][C - 1] + Arr[D - 1][C];
			}
		}
		for (D = 0; D < n; D++) {
			for (C = 0; C <= D; C++) {
				System.out.print("\t" + Arr[D][C] );
			}
			System.out.println();

		}
	}
}

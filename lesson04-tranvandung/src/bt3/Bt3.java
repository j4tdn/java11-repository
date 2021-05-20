package bt3;

import java.util.Scanner;

public class Bt3 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap Do Dai n = ");
		int n = ip.nextInt() + 2;
		int[][] Arr = new int[n][n];
		System.out.println("Tam giac Pascal La: ");
		for (int D = 0; D < n; D++) {
			Arr[D][0] = 1;
			for (int C = 1; C <= D; C++) {
				Arr[D][C] = Arr[D - 1][C - 1] + Arr[D - 1][C];
			}
		}
		for (int D = 0; D < n; D++) {
			for (int C = 0; C <= D; C++) {
				System.out.print("\t" + Arr[D][C]);
			}
			System.out.println();
		}
	}
}

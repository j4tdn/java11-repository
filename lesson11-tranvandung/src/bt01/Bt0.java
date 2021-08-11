package bt01;

import java.util.Scanner;

public class Bt0 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.printf("Nhập n: ");
		int n = ip.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int i1 = n + 1; i <= (2 * n - 1); i++) {
				for (int j = 1; j <= i; j++) {
					for (int j1 = n + 1; j1 <= i; j1++) {

						System.out.print(j + " ");

						System.out.print(j1 + " ");
					}
					System.out.println();
				}
//		for (int i = n-1; i >= 1; --i) {
//			for (int j = 1; j <= i; ++j) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}

			}
		}
	}
}

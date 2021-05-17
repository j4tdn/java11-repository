package bai_02_03;

import java.util.Scanner;

public class bai_03 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n;
		System.out.println("moi nhap n: ");
		n = Integer.parseInt(s.nextLine());
		for(int i = 0; i<=n+1; i++ ) {
			for(int j = 0; j <= i; j++) {
				System.out.print(Pascal(j, i)+" ");
			}
			System.out.println();
		}

	}

	private static int Pascal(int h, int n) {
		if (h == 0 || h == n) {
			return 1;
		} else {
			return Pascal(h - 1, n - 1) + Pascal(h, n - 1);
		}
	}

}

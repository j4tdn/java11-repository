package baitap;

import java.util.Random;

public class Bt07 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] A = new int[5];
		int n;
		int chiso = 0;
		do {
			n = 20 + rd.nextInt(11);
			if (check(A, n, chiso)) {
				A[chiso] = n;
				System.out.print(" " + A[chiso]);
				chiso++;

			}

		} while (chiso < 5);
	}

	private static boolean check(int[] list, int n, int chiso) {
		for (int i = 0; i < chiso; i++) {
			if (n == list[i]) {
				return false;
			}
		}
		return true;
	}
}

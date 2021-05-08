package baitap;

import java.util.Random;

public class Bai7_C2 {
	public static void main(String[] args) {
		int[] data = new int[5];
		int a, i = 0;
		Random rd = new Random();

		do {
			a = 20 + rd.nextInt(30 - 20) + 1;
			if (contains(data, a)) {
				continue;
			}
			System.out.print(a+" ");
			data[i++] = a;
		} while (i < 5);
	}

	private static boolean contains(int[] data, int a) {
		for (int i = 0; i < data.length; i++) {
			if (data[i] == a) {
				return true;
			}
		}
		return false;
	}
}

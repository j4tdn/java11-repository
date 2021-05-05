package data;

import java.util.Random;

public class Hw07 {
	public static void main(String[] args) {
		int[] a = new int[5];
		Random rd = new Random();
		for (int i = 0; i < a.length; i++) {
			do {
				a[i] = 20 + rd.nextInt(11);
			} while (contains(i, a, a[i]));
			System.out.println(a[i]);
		}
	}

	private static boolean contains(int n, int[] array, int test) {
		for (int i = 0; i < n; i++) {
			if (array[i] == test)
				return true;
		}
		return false;
	}

}
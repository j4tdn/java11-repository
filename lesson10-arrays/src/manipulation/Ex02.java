package manipulation;

import Utils.ArraysUtils;

public class Ex02 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int[] b = { 1, 2, 3, 4, 5, 6 };
		
 		reserver(a);
		ArraysUtils.printf(a);
		ArraysUtils.printf(b);
	}

	private static void reserver(int[] validData) {
		for (int i = 0; i < validData.length / 2; i++) {
			int temp = validData[i];
			validData[i] = validData[validData.length - i - 1];
			validData[validData.length - i - 1] = temp;
		}

	}
}

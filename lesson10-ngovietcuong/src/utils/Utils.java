package utils;

public class Utils {
	private Utils() {
	}

	public static void printf(int[] digits) {
		for (int digit : digits) {
			System.out.print(digit + " ");
		}
	}

	public static void printf(int[][] digits) {
		for (int[] digit : digits) {
			for (int i = 0; i < digit.length; i++) {
				System.out.print(digit[i] + " ");
			}
			System.out.println();
		}
	}
}

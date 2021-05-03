package baitap;

public class Bai02 {
	public static void main(String[] args) {
		int[] array = { 4, 7, 2, 12, 18 };
		int n = array.length;
		System.out.println("tong giai thua: " + tonggt(array, n));
	}

	private static int gt(int n) {
		int gt = 1;
		for (int i = 1; i <= n; i++) {
			gt *= i;
		}
		return gt;
	}

	private static int tonggt(int[] array, int n) {
		int tong = 0;
		for (int i = 0; i < n; i++) {
			tong += gt(array[i]);
		}
		return tong;
	}
}

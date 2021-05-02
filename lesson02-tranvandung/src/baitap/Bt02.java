package baitap;

public class Bt02 {
	public static void main(String[] args) {
		System.out.println("Tong S = " + sum(4, 7, 12, 18));

	}
	
	private static long sum(int a, int b, int c, int d) {
		long sum = factorial(a) + factorial(b) + factorial(c) + factorial(d);
		return sum;
	}

	// tinh giai thua
	private static long factorial(int n) {
		long gt = 1;
		for (int i = 2; i <= n; i++) {
			gt = gt * i;
		}
		return gt;
	}
}

package exam;

public class Ex02 {
	public static void main(String[] args) {
		int n = 6;

		int[] Ak = { 3, 2, 1, 6, 5 };

		System.out.println(getMissingNumber(Ak, n));

	}

	public static int getMissingNumber(int[] Ak, int n) {
		int sumMiss = 0;
		int sum = 0;
		for (int i = 0; i < Ak.length; i++) {

			sumMiss += Ak[i];
		}

		for (int i = 1; i <= n; i++) {
			sum += i;
		}

		return sum - sumMiss;
	}
}

package view;

public class Ex02 {
	public static void main(String[] args) {
		int n = 10;
		int sum1 = 0;
		int sum2 = 0;
		int[] arr = { 3, 7, 9, 2, 1, 6, 5, 4, 10 };
		for (int i = 1; i <= n; i++) {
			sum1 += i;
		}
		for (int i = 0; i < n - 1; i++) {
			sum2 += arr[i];
		}
		System.out.println(sum1 - sum2);
	}
}

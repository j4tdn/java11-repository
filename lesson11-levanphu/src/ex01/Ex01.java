package ex01;

public class Ex01 {
	public static void main(String[] args) {
		int n = 3;

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				if (j <= i || j>= 2 * n - i) {
					System.out.print(j + " ");
				} else {
					System.out.print("  ");
				}

			}
			System.out.println();
		}
		for (int i = n - 1; i >=1; i--) {
			for (int j = 1; j <= 2 * n - 1; j++) {
				if (j <= i || j>= 2 * n - i) {
					System.out.print(j + " ");
				} else {
					System.out.print("  ");
				}

			}
			System.out.println();
		}
	}
}

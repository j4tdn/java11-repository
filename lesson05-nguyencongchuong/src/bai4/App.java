package bai4;

public class App {
	public static void main(String[] args) {
		int[] array = { 1, 2, 3};
		System.out.println(getLeastCommonMultiple(array));
	}

	private static int UCLN(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a > b) {
			return UCLN(a - b, b);
		}
		return UCLN(a, b - a);
	}

	private static int BCNN(int a, int b) {
		return (a * b / UCLN(a, b));
	}

	private static int getLeastCommonMultiple(int[] a) {
		int temp = BCNN(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			temp = BCNN(temp, a[i]);
		}
		return temp;
	}
}

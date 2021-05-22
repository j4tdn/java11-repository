package bt4;

public class Bt04 {
	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 7, 8, 9, 4 };
		System.out.println("BCNN la : " + getLeastCommonMultiple(a));
	}

	public static int UCLN(int a, int b) {
		if (a == 0 || b == 0) {
			return a + b;
		}
		while (a != b) {
			if (a > b) {
				a -= b; // a = a - b
			} else {
				b -= a;
			}
		}
		return a;
	}

	public static int BCNN(int a, int b) {
		return (a * b / UCLN(a, b));
	}

	public static int getLeastCommonMultiple(int a[]) {
		int temp = BCNN(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			temp = BCNN(temp, a[i]);
		}
		return temp;
	}
}

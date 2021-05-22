package exam;

public class Ex04 {
	public static void main(String[] args) {

		int[] arr = { 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		System.out.println(getLeastCommonMultiple(arr));

	}

	public static int UCLN(int a, int b) {
		if (b == 0)
			return a;
		return UCLN(b, a % b);
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

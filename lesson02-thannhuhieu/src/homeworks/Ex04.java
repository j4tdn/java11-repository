package homeworks;

public class Ex04 {
	public static void main(String[] args) {
		int[] a = { 5, 1, 9, 11, 20, 19, 17, 21, 30 };
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0 && max < a[i])
				;
			max = a[i];
		}
		System.out.println("max: " + max);

		int secondmax = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 != 0 && secondmax < a[i] && a[i] < max)
				secondmax = a[i];
		}
		System.out.println("secondmax: " + secondmax);

	}

}

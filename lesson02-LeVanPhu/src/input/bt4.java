package input;

public class bt4 {
	public static void main(String[] args) {
		int a[] = { 2, 4, 6, 7, 23, 52, 22 };
		System.out.println(LeMax(a));
	}

	private static int LeMax(int a[]) {
		int max = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] % 2 == 1) {
				if (max < a[i]) {
					max = a[i];
				}
			}
		}
		return max;
	}
}

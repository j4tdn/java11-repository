package hw3;

public class Pascal {
	public static void main(String[] args) {
		int n = 4;
		System.out.println("==============PASCAL==============");
		for(int i = 0; i <= n + 1; i++ ) {
			if(i==0) {
				continue;
			}
			for(int j = 0; j <= i; j++) {
				System.out.printf("%-7d",Cal(j, i));
			}
			System.out.println();
		}
	}

	public static int Cal(int k, int n) {

		if (k == 0 || k == n) {
			return 1;
		}
		if (k == 1) {
			return n;
		}
		return Cal(k - 1, n - 1) + Cal(k, n - 1);

	}
}

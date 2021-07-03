package homework04;

public class Hw04 {
	public static void main(String[] args) {
		int m = 12;
		int n = 60;
		int a = 75;
		int b = 15;
		boolean result = isEquivalent(n, m);
		
		System.out.println("========================");
		System.out.println("result: " + result);
		System.out.println("75 vs 15: " + isEquivalent(a, b));
		System.out.println("12 vs 18: " + isEquivalent(12, 18));
	}

	private static boolean isEquivalent(int num1, int num2) {
		int count = 0;
		int a = 0;
		for (int i = 2; i < num1 / 2; i++) {
			if (num1 % i == 0) {
				boolean p = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						p = false;
					}
				}
				if (p) {
					count++;
				}
			}
		}
		int[] divisor = new int[count];
		for (int i = 2; i < num1 / 2; i++) {
			if (num1 % i == 0) {
				boolean p = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						p = false;
						break;
					}
				}
				if (p) {
					divisor[a] = i;
					a++;
				}
			}
		}

		int count1 = 0;
		int a1 = 0;
		for (int i = 2; i < num2 / 2; i++) {
			if (num2 % i == 0) {
				boolean p = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						p = false;
					}
				}
				if (p) {
					count1++;
				}
			}
		}
		int[] divisor1 = new int[count1];
		for (int i = 2; i < num2 / 2; i++) {
			if (num2 % i == 0) {
				boolean p = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						p = false;
						break;
					}
				}
				if (p) {
					divisor1[a1] = i;
					a1++;
				}
			}
		}

		if (divisor.length != divisor1.length) {
			return false;
		}
		String x = "";
		for (int i = 0; i < divisor.length; i++) {
			x += divisor[i];
		}
		String y = "";
		for (int i = 0; i < divisor1.length; i++) {
			y += divisor1[i];
		}
		return x.equals(y);
	}
}

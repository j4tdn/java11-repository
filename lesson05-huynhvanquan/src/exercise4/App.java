package exercise4;

public class App {
	public static void main(String[] args) {
		int[] numList = new int[] { 12, 15, 6 };
		System.out.println("BCNN cua cac phan tu trong mang: " + getLeastCommonMultiple(numList));
	}

	public static int getLeastCommonMultiple(int[] numList) {
		int result = LCM(numList[0], numList[1]);
		for (int i = 2; i < numList.length; i++) {
			result = LCM(numList[i], result);
		}
		return result;
	}

	public static int GCD(int a, int b) {
		if (a == 0) {
			return b;
		}
		return GCD(b % a, a);
	}

	public static int LCM(int a, int b) {
		return a * b / GCD(a, b);
	}

}

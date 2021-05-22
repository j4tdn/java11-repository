package bai_03;

public class Bai_03 {
	public static void main(String[] args) {
		isPowerOf(8, 2);
		isPowerOf(2, 8);
		isPowerOf(6, 2);
		isPowerOf(20, 4);
		isPowerOf(64, 4);

	}

	public static void isPowerOf(int n, int m) {
		double lognm = Math.log(n) / Math.log(m);
		int lognmi = (int) (Math.floor(lognm));
		if (lognm - lognmi == 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}

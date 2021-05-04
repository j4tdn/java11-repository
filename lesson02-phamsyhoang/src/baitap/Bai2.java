package baitap;

public class Bai2 {
	public static void main(String[] args) {
		int a = 4, b = 7, c =12, d = 18;
		double s = TinhGiaiThua(a) + TinhGiaiThua(b) + TinhGiaiThua(c) + TinhGiaiThua(d);
		System.out.println("S = 4! + 7! + 12! + 18! = " + s);

	}

	private static double TinhGiaiThua(int n) {
		double s = 1;
		if (n == 0) {
			return 1;
		}
		if(n>=1) {
			for (int i = 1; i <= n; i++) {
				s *= i;
			}
			return s;
		}
		return -1;
	}
}

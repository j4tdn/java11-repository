package bt;

public class Bai2 {
	public static void main(String[] args) {

		int n1 = 4;
		int n2 = 7;
		int n3 = 12;
		int n4 = 18;

		System.out.println("Tổng giai thừa S: " + tongGiaiThua(n1, n2, n3, n4));

	}

	private static long giaiThua(int n) {
		long gt = 1;
		for (int i = 2; i <= n; i++) {
			gt = gt * i;
		}
		return gt;
	}

	private static long tongGiaiThua(int n1, int n2, int n3, int n4) {
		long s = giaiThua(n1) + giaiThua(n2) + giaiThua(n3) + giaiThua(n4);
		return s;
	}
}

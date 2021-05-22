package ex04;

public class Ex04 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		System.out.println(BSCNN_Mang(a));
	}

	public static int USCLN(int a, int b) {
		if (b == 0)
			return a;
		return USCLN(b, a % b);
	}

	public static int BSCNN(int a, int b) {
		return (a * b) / USCLN(a, b);
	}

	public static int BSCNN_Mang(int[] a) {
		int temp = BSCNN(a[0], a[1]);
		for (int i = 2; i < a.length; i++) {
			temp = BSCNN(temp, a[i]);
		}
		return temp;
	}

}

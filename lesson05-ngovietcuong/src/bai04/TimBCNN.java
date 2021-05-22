package bai04;

public class TimBCNN {
	public static void main(String[] args) {
		int[] A = new int[5];
		A[0] = 2;
		A[1] = 4;
		A[2] = 6;
		A[3] = 8;
		A[4] = 10;
		
		System.out.println("BCNN cua cac phan tu trong mang: " + getLeastCommonMultiple(A));
	}

	public static int UCLN(int a, int b) {
		if (a == b)
			return a;
		if (a > b) {
			a = a - b;
		} else {
			b = b - a;
		}
		return a;
	}

	public static int BCNN(int a, int b) {
		return (a * b) / UCLN(a, b);
	}

	public static int getLeastCommonMultiple(int[] A) {
		int tmp = BCNN(A[0], A[1]);
		for (int i = 2; i < A.length; i++) {
			tmp = BCNN(tmp, A[i]);
			
		}
		return tmp;
	}

}

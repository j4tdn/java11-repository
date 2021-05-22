package ex02;

public class Ex02 {
	public static void main(String[] args) {
		int[] A = { 3, 2, 1, 6, 5 };
		System.out.println(getMissingNumber(A));

	}

	public static int getMissingNumber(int[] A) {
		int dem;
		for (int i = 1; i <= A.length; i++) {
			dem = 0;
			for (int j = 0; j < A.length; j++) {
				if (i == A[j]) {
					dem++;
					break;
				}
			}
			if (dem == 0) {
				return i;
			}
		}
		return 0;
	}
}
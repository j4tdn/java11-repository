package ex01;

public class Ex01UniqueNum {
	public static void main(String[] args) {
		int[] A = { 3, 15, 21, 0, 15, 17, 21 };
		int n = A.length;
		System.out.println("The unique number is: " + getUniqueNumbers(A, n));
	}

	public static int getUniqueNumbers(int[] A, int n) {

		for (int i = 0; i < n - 1; i += 2)
			if (A[i] != A[i + 1])
				return A[i];
		return A[n - 1];

	}
}

package ex01;

public class Ex01Main {
	public static void main(String[] args) {
		int[] A = { 3, 15, 21, 0, 15, 17, 21 };
		int n = 6;
		int[] B = getUniqueNumbers(A, n);
		for (int i = 0; i < B.length; i++) {
			System.out.print(B[i] + " ");
		}
	}

	private static int[] getUniqueNumbers(int[] A, int n) {
		int[] B = new int[A.length];
		int z = 0;
		for (int i = 0; i < A.length - 1; i++) {
			int tmp = A[i];
			if (isUniqueNumber(tmp, A, i)) {
				B[z++] = tmp;
			}
		}
		
		int[] result = new 	int[z];
		for(int i = 0; i < z; i++) {
			result[i] =  B[i];
		}
		return result;
	}

	private static boolean isUniqueNumber(int tmp, int[] a, int index) {
		for (int i = 0; i < a.length; i++) {
			if (i != index && a[i] == tmp) {
				return false;
			}
		}
		return true;
	}
}

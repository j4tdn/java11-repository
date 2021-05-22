package ex04;

public class Ex04Main {
	public static void main(String[] args) {
		int n = 4;
		int[] A = { 1, 4, 3, 6 }; // 12
		System.out.println("BCNN : " + getLeastCommonMutiple(A, n));
	}

	private static int getLeastCommonMutiple(int[] a, int n) {
		 int tmp =  BCNN(a[0], a[1] );
	        for(int i=2;i<n;i++){
	            tmp = BCNN(tmp, a[i]);    
	        }
	        return tmp;
	}

	private static int UCLN(int a, int b) {
		if (a == b)
			return a;
		if (a > b) {
			a = a - b;
		} else {
			b = b - a;
		}
		return a;
	}

	private static int BCNN(int a, int b) {
		return (a * b / UCLN(a, b));
	}
}

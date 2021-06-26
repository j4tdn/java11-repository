package ex04;

public class App {
	public static void main(String[] args) {
		int n =75, m=15;
		//check(n, m);
		int[] a;
		int count=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				a[count]=i;
				count++;
			}
		}
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}
	}
	
	private static boolean isPrime(int n) {
		if(n<2) {
			return false;
		}
		int squareRoot = (int)Math.sqrt(n);
		for(int i=2;i<squareRoot;i++) {
			if(i%n==0) {
				return false;
			}
		}
		return true;
	}
	
	private static int[] findDivisor(int n) {
		int[] a= new int[100];
		int count=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				a[count]=i;
				count++;
			}
		}
		return a;
	}
	
	private static void check(int n, int m) {
		System.out.println(findDivisor(n));
	
	}
}


public class Ex04 {
	public static void main(String[] args) {
		System.out.println(equivalentPrime(75,15));
	
	}
	
	private static boolean prime(int a) {
		if(a == 1 || a == 0) {
			return false;
		}
		int count = 0;
		for(int i = 2; i < a; i++) {
			if(a % i == 0) {
				count++;
			}
		}
		if(count == 0) {
			return true;
		}
		return false;
	}
	
	private static boolean equivalentPrime(int a, int b) {
		int index = 0;
		int count = 0;
		int c = a;
		if(a > b) {
			c = b;
		}
		int[] m = new int[c];
		for(int i = 2; i <= c; i++) {
			if(a % i == 0 && b % i == 0) {
				m[index++] = i;
			}
		}
		for(int i = 0; i < m.length; i++) {
			if(prime(m[i]) == true) {
				count++;
			}
		}
		if(count > 0) {
			return true;
		}
		return false;
	}

}

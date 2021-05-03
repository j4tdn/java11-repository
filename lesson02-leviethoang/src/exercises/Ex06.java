package exercises;

public class Ex06 {
	public static void main(String[] args) {
		Prime200();
	}

	private static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	// Prime(200)
	private static void Prime200() {
		int i = 2, count = 0;
		while(true) {
			if(isPrime(i)) {
				count ++;
				if(count == 200) {
					System.out.println("Prime(200) : " + i);
				}
			}
			i++;
		}
	}
}

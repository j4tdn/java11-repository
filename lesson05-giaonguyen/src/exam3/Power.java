package exam3;

public class Power {
	public static void main(String[] args) {

		System.out.println(isPowerOf(8, 2));
		System.out.println(isPowerOf(2, 8));
		System.out.println(isPowerOf(6, 2));
		System.out.println(isPowerOf(20, 4));
		System.out.println(isPowerOf(64, 4));
		System.out.println(isPowerOf(5, 20));
		
	}
	
	public static boolean isPowerOf(int a, int b) {
		int base = 0;
		int pow = 0;
		int result = 0;
		
		if  (a > b) {
			base = b;
			pow = a;
		}
		else {
			base = a;
			pow = b;
		}
		
		result = base;
		while (result <= pow) {
			result *= base;
		}
		
		if (result % pow == 0) 
			return true;
		
		return false;
	}
}

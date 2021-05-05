package exercise;

public class Ex03 {
	public static void main(String[] args) {
		System.out.println(symmetricalNumber(1));
	}
	private static boolean symmetricalNumber(int n) {
		int reversed = 0;
		int original = n;
		while(n != 0) {
		      int digit = n % 10;
		      reversed = reversed * 10 + digit;
		      n /= 10;
		}
		if(reversed == original){
			return true;
		}
		return false;
	}
}

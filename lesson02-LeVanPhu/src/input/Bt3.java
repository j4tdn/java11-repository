package input;

public class Bt3 {
	public static void main(String[] args) {
		int n = 11112;
		boolean SDX = SDX(n);
		if (SDX == true ) {
			System.out.println( n + " la so doi xung ");
		} else {
			System.out.println(n + " khong phai la so doi xung");
		}
	}
	private static boolean SDX(int n) {
	     int origin = n  , rever = 0, rem ;
		while(n != 0) {
			rem = n % 10;
			rever = rever * 10 + rem;
			n /= 10;
		}
		if (origin == rever) {
			return true;
		}
		return false;
		
	}
	 }


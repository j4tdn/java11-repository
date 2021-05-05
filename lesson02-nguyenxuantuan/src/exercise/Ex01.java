package exercise;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(8));
	}
	private static boolean isPowerOfTwo(int n){
		if( 0 == n|| 1 == n ) return true;
		int x = n / 2;
		int y = n%2;
		if (1 == y) return false;
		return isPowerOfTwo(x);
	
	}
}

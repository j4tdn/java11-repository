
public class Ex01 {
	public static void main(String[] args) {
		System.out.println("1: " + isPowerOfTwo(1));
		System.out.println("4: " + isPowerOfTwo(4));
		System.out.println("8: " + isPowerOfTwo(8));
		System.out.println("6: " + isPowerOfTwo(6));
		System.out.println("12: " + isPowerOfTwo(12));
	}

	private static boolean isPowerOfTwo(int number) {
		int i = 0;
		while (true) {
			if (number == Math.pow(2, i)) {
				return true;
			}
			if (Math.pow(2, i) > number) {
				return false;
			}
			i++;
		}
	}
}

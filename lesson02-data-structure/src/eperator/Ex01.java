package eperator;

public class Ex01 {
	public static void main(String[] args) {
		//isEven
		int a = 94;
		boolean even = isEven(a);
		// if (!even) == if (even == false)
		if (even) {
			System.out.println(a + " is even number");
		} else {
			System.out.println(a + " is odd number");
		}
		System.out.println(a + " is " + (even ? "even" : "odd") + " number");
		
		int i = 5;
		++i; // i = 1 + i
		System.out.println(i);
	}
	private static boolean isEven(int input) {
		return input % 2 == 0;
	}

}

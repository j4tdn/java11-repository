package inheritance.functionalinterface;

public class App {
	public static void main(String[] args) {
		int[] digits = { 1, 4, 8, 12, 25, 60 };
//		System.out.println(countEven(digits));
//		System.out.println(countOdd(digits));
//		System.out.println(countDivisible3(digits));
//		System.out.println(countDivisible5(digits));
		
		System.out.println("count even: " + count(digits, num -> num % 2 == 0));
		System.out.println("count odd: "  + count(digits, num -> num % 2 != 0));
		System.out.println("count d3: "   + count(digits, num -> num % 3 == 0));
		System.out.println("count d5: "   + count(digits, num -> num % 5 == 0));
		
		
		
	}
	
	private static int count(int[] digits, Condition con) {
		int count = 0;
		for (int digit: digits) {
			if (con.test(digit)) {
				count++;
			}
		}
		return count;
	}
	
	public static int countEven(int[] arr) {
		int n = 0;
		for (int i : arr) {
				n++;
		}
		return n;
	}

	public static int countOdd(int[] arr) {
		int n = 0;
		for (int i : arr) {
			if (i % 2 != 0)
				n++;
		}
		return n;
	}

	public static int countDivisible3(int[] arr) {
		int n = 0;
		for (int i : arr) {
			if (i % 3 == 0)
				n++;
		}
		return n;
	}

	public static int countDivisible5(int[] arr) {
		int n = 0;
		for (int i : arr) {
			if (i % 5 == 0)
				n++;
		}
		return n;
	}
}

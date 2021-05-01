package operator;

public class Ex01 {
	public static void main(String[] args) {
		// isEven
		int n = 20;
		boolean isEven = isEven(n);
		
		// if (isEven) => if (isEven == true)
		// if (!isEven) => if (isEven == false)
		if (!isEven) {
			System.out.println(n + " is odd number");
		} else {
			System.out.println(n + " is even number");
		}
		
		System.out.println(n + " is " + (isEven ? "even" : "odd") + "number" );
		
		// && ||
		if (n % 2 == 0 && n % 10 == 0) {
			System.out.println("TRUE");
		}
		
		// Condition operator ?:
		// BT ? Code1 : Code2
		// if (BT == true) {
			   // Code 1
	    // } else {
		      // Code 2
	    // }
		
		int i = 5;
		// i += 1; // i = i + 1;
		// i = i +1;
		// i++; // suffix i = i + 1
		// ++i; // prefix i = 1 + i
		
		System.out.println("i " + (i++));
		System.out.println("i " + i);
	}
	
	
	
	private static boolean isEven(int input) {
		return input % 2 == 0;
	}
}

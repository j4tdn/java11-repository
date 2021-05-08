package operator;

public class Ex01 {
	public static void main(String[] args) {
		//isEven
		int n = 21;
		
		boolean isEven = isEven(n); 
		
		//if (isEven) => if (isEven = true)
		// if (!isEven) => if (isEven == false)
		if (!isEven) {
			System.out.println(n + " is odd number");
			} else {
				System.out.println(n + " is even number");
			}
		
		//
		System.out.println(n + "is" + (isEven ? "even" : "odd") + "number" );
	
	// && ||
		if (n % 2 == 0 && n % 10 == 0) {
			System.out.println("True");
			} 
		
		
	}

		
		
	
		
	
	private static boolean isEven(int input) {
		return input % 2 == 0;
		
	}
}

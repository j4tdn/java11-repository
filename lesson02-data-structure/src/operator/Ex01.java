package operator;

public class Ex01 {
	public static void main(String[] args) {
		int n = 20;
		boolean isEven = isEven(n);
		// if (isEven) => if (isEven == true)
		// if (isEven) => if (isEven == false)
		if (!isEven) {
			System.out.println(n + "is odd number");
		} else {
			System.out.println(n + "is even number");
		}
	
	System.out.println(n + "is" + (isEven ? "even" : "odd" + "number"));

	}
	private static boolean isEven(int input) {
		return input % 2 == 0;
	
	}
}

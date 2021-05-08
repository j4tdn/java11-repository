package operator;

public class Ex01 {
	public static void main(String[] args) {
		// is a even number
		int input = 20;
		boolean isEven = isEven(input);
		// if (isEven) => if (isEven == true)
		// if (!isEven) => if (isEven == false)
		if (!isEven) {
			System.out.println(input + " is odd number");
		}else {
			System.out.println(input + " is even number");
		}
		// BT ? code1 : code 2
		// ? if is true
		// : else is false
		System.out.println(input + " is " + (isEven ? "even" : "odd") + " number");
	}
	
	private static boolean isEven(int input) {
		return input % 2 == 0;
	}
    
}

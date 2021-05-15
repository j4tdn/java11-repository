package operator;

public class Ex01 {
	public static void main(String[] args) {
		// Toán tử 1 ngôi
		int number = 8;
		// operator: prefix, suffix
		
		System.out.println(number++);
		
		// !: phu dinh => true, false
		System.out.println(!true);
		
		boolean isEven = isEven(13);
		if (isEven) {
			System.out.println("So chan");
		}
		
		if (!isEven) {
			System.out.println("So le");
		}
		
		System.out.println("=======================");
		// condition operator
		int a = 2;
		int b = 2;
		// BT1, BT2, Body
		// T	T	YES
		// T	F	NO
		// F	NO	NO
		if (a > 1 && b++ > 3) {
			System.out.println("Good condition !!!");
		}
		System.out.println("b: " + b);
		
		int c = 2;
		int d =2;
		// BT1, BT2, Body
		// F	F	NO
		// F	T	YES
		// T	NO	NO
		if (c > 1 || d++ > 3) {
			System.out.println("Good condition !!!");
		}
		
		System.out.println("d: " + d);
	}
	
	private static boolean isEven(int input) {
		return input % 2 == 0;
	}
}

package operator;

public class Ex01 {
	public static void main(String[] args) {
		// isEven? (kiem tra so co phai so chan k)
		int n = 21;
		boolean isEven = isEven(n);
		
		// if (isEven) <=> if (isEven) == true
		// is (!isEven) <=> if (isEven) == false
		// if k có return thì k đc bỏ else
		if (!isEven) {
			System.out.println(n + " is odd number");
		} else {
			System.out.println(n + " is even number");
		}
		
		// Condition operator ?:
		// BT ? Code1: Code2
		// if (BT == true) {
		// 		Code1
		// } else {
		//		Code2
		// }
		System.out.println(n + " is " + (isEven ? "even" : "odd") + " number");
		
		// && ||
		if (n % 2 == 0 && n % 10 == 0) {
			System.out.println("TRUE");
		}
		
	}
	
	private static boolean isEven(int input) {
		return input % 2 == 0;
	}
}

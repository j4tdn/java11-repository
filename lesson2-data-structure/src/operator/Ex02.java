package operator;

public class Ex02 {
	public static void main(String[] args) {
		// Condition operator: ?:
		// expression ? A : B;
//		if (expression) {
//			// A
//		} else {
//			//B
//		}
		
		// parameter = expression ? A : B;
		int number = 10;
		boolean isEven = number % 2 == 0;
		System.out.println(isEven);
		
		// max 2 so
		int first = 7;
		int second = 8;
		int third = 22;
		System.out.println("max: " + max(second, third));
		System.out.println("max: " + max(first, second, third));
	}
	
	private static int max(int first, int second) {
		return first > second ? first : second;
	}
	
	private static int max(int first, int second, int third) {
		return max(max(first, second), third);
	}
}

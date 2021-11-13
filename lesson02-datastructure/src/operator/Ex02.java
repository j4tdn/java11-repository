package operator;

public class Ex02 {
	public static void main(String[] args) {
		// Toán tử điều kiện ?:
		// expression ? A : B;

		// parameter = expression ? A : B;

		int number = 10;
		boolean isEven = (number % 2 == 0) ? true : false;
		System.out.println(isEven);

		// max 2 so
		int first = 7, second = 8;
		System.out.println("max: " + max(first, second));

		// max 3 so
		int third = 2;
		System.out.println("max 3 so: " + max(max(first, second), third));
	}

	private static int max(int first, int second) {
		return first > second ? first : second;
	}

	private static int max(int first, int second, int third) {
		//int max = first > second ? first : second;
		// return max>third ? max: third;
		
		return ((first > second) && (first > third)) 
				?first : (second > third) ? second : third;
	}

}
package data;

public class Ex07PrimitiveOrObject {
	public static void main(String[] args) {
		// Check a character is number or not
		char input = '5';
		System.out.println("primitive: " + isDigit(input));
		System.out.println("Object: " + Character.isDigit(input));
	}
	// primitive type
	private static boolean isDigit(char input) {
		return input >= 0 && input <= 9;
	}

}

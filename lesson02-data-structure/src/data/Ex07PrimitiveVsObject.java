package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		// Check a character number or not

		char input = '7';
		String s = "123abc";

		System.out.println("primitive: " + isDigit(input));

		System.out.println("object: " + Character.isDigit(input));
		System.out.println("is Number: " + s.matches("[0-9]+"));

		// s.matches("[0-9]+{2,}") check number > 2digits

	}

	private static boolean isDigit(char input) {
		return (input >= '0' && input <= '9');
	}

}

package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		char input = 'a';
		System.out.println("Primitive: " + isDigit(input));
		System.out.println("Object: " + Character.isDigit(input));

		String s = "123456";
		System.out.println("isNumber:" + s.matches("[0-9]{2,}"));
	}

	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9';
	}
}

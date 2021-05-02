package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		char input = 'q';
		System.out.println("primitive: " + isDigit(input));
		System.out.println("Object: " + Character.isDigit(input));

		String s = "12345";
		System.out.println("isnumber:" + s.matches("[0-9]{2,}"));
	}

	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9';
	}
}

package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		
		char input = '7';
		System.out.println("primitive: " + isDigit(input));
		System.out.println("object: " + Character.isDigit(input));
		
		String s = "12345";
		System.out.println("isNumber: " + s.matches("[0-9]{1,}"));
	}
	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9';
	}
}

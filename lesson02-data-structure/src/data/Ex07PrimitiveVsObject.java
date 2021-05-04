package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		//Check a character is number or not
		char input = '7';
		System.out.println("primitive: " + isDigit(input));
		System.out.println("Object: " + Character.isDigit(input));
		String s = "12345";
		System.out.println("isNumber: " + s.matches("[0-9]{2}"));
			
	}
	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9' ;
		}
}

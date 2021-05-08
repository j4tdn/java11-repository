package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		//Check a character is Digit 
		
		char input = 'c';
		System.out.println("Primitive: " + isDigit(input));
		System.out.println("Object: " + Character.isDigit(input));
	}
	
	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9';
	}
}

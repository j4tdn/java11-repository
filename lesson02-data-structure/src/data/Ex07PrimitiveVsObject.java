package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		// check a character is number >
		char input = 'q';
		System.out.println("primitive: " + isDigit);
		System.out.println("Object: " + Character.isDigit(input));
		
		String s= "12345";
		System.out.println("isNumber: " + s.matches("[0-9]{2"));
	}
	
	
	 //primitive type
	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9';
	}

}

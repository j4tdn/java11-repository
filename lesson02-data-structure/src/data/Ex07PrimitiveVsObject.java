package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		char c = '7';
		System.out.println("primitive : " + isDigit(c));
		System.out.println("primitive : " + Character.isDigit(c));
		
	}
	private static boolean isDigit(char c) {
		return c >= '0' && c <= '9';
			
	}
}

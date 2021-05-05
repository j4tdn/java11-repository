package data;

public class Ex07PrimitiveVsObject {
	public static void main(String[] args) {
		// Check a character || sequence is a number or not
		char input = 'q';

		System.out.println("primitive: " + isDigit(input));
		System.out.println("Object: " + Character.isDigit(input));

		String s = "12345";
		System.out.println("isNumber: " + s.matches("[0-9]{1,}"));
		// matches ktra các kí tự thuộc phạm vi 0-9 và từ 2 kí tự trở lên
	}

	// primitive
	private static boolean isDigit(char input) {
		return input >= '0' && input <= '9';

	}

}

package data;

public class Ex08 {
	public static void main(String[] args) {

		// ctrl + shift + o --> remove redundant import
		// char, Character
		char a = 'x';
		char b = '5';

		System.out.println("a " + isDigist(a));
		System.out.println("b " + isDigist(b));

		System.out.println("a " + Character.isDigit(a));

	}

	private static boolean isDigist(char tmp) {
		return (tmp >= '0'&& tmp<= '9');
	}
}
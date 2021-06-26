package ex01;

public class Character {
	public static void main(String[] args) {
		String str = "Hello world";
		
		System.out.println("=====EACH CHARACTER IN A LINE=====");
		splitChars(str);
		
		System.out.println("=====EACH WORD IN A LINE=====");
		splitWords(str);
		
		System.out.println("=====REVERSE WORDS=====");
		reverseWords(str);
		
		System.out.println();
		System.out.println("=====REVERSE CHARACTERS=====");
		reverseChars(str);
	}
	
	private static String splitChars(String line) {
		String string = line;
		
		for (int i = 0; i < string.length(); i++) {
			System.out.println(string.charAt(i));
		}
		
		return string;
	}
	
	private static String splitWords(String line) {
		String string = line;
		String [] splitStr = string.split(" ");
		
		for (int i = 0; i < splitStr.length; i++) {
			System.out.println(splitStr[i]);
		}
		
		return string;
	}
	
	private static String reverseWords(String line) {
		String string = line;
		String [] splitStr = string.split(" ");
		
		for (int i = splitStr.length - 1; i >= 0 ; i--) {
			System.out.print(splitStr[i] + " ");
			
		}
		
		return string;
	}
	
	private static String reverseChars(String line) {
		String string = line;
		
		for (int i = string.length()-1; i >= 0; i--) {
			System.out.print(string.charAt(i));
		}
		
		return string;
	}
}

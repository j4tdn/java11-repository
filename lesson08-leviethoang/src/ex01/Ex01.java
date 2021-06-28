package ex01;

public class Ex01 {
	public static void main(String[] args) {
		String input = "Lê     Việt     Hoàng   JAVA11";
		printChar(input);
		printWord(input);
		reverseChar(input);
		reverseWord(input);
	}
	
	private static void printChar(String input) {
		input = input.replaceAll("\\s+", "");
		for(int i = 0; i < input.length(); i++) {
			System.out.print(input.charAt(i)+ " ");
		}
		System.out.println();
	}
	
	private static void printWord(String input) {
		String[] result = input.split("\\s+");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+ " ");
		}
		System.out.println();
	}
	
	private static void reverseChar(String input) {
		StringBuilder result = new StringBuilder(input);
		result.reverse();
		printChar(result.toString());
	}
	
	private static void reverseWord(String input) {
		StringBuilder result = new StringBuilder(input);
		result.reverse();
		printWord(result.toString());
	}
	
}

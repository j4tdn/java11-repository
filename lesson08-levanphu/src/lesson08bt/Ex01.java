package lesson08bt;

public class Ex01 {
	public static void main(String[] args) {
		String str = "Lê Văn Phú";
		characters(str);
		Word(str);
		reverseChar(str);
		reverseWord(str);
	}
	
	private static void characters(String str) {
		str = str.replaceAll("\\s+", "");
		for(int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i)+ " ");
		}
		System.out.println();
	}
	
	private static void Word(String str) {
		String[] result = str.split("\\s+");
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+ " ");
		}
		System.out.println();
	}
	
	private static void reverseChar(String str) {
		StringBuilder result = new StringBuilder(str);
		result.reverse();
		characters(result.toString());
	}
	
	private static void reverseWord(String str) {
		StringBuilder result = new StringBuilder(str);
		result.reverse();
		Word(result.toString());
	}
}

package ex01;

public class App {
	public static void main(String[] args) {
		String text = "Chuỗi chỉ chứa các kí tự tiếng việt có dấu, phím space";
		charLine(text);
		System.out.println("====================");
		wordLine(text);
		System.out.println("====================");
		reverse(text);
	}

	private static void charLine(String text) {
		char[] charArray = text.toCharArray();
		for (char a : charArray) {
			System.out.println(a);
		}
	}

	private static void wordLine(String text) {
		for (String texts : text.split("\\s+")) {
			System.out.println(texts);
		}
	}

	private static void reverse(String text) {
		for (String texts : text.split("\\s+")) {
			StringBuilder tBuilder = new StringBuilder(texts);
			System.out.println(tBuilder.reverse());
		}
		System.out.println("=================");
		for (String texts : text.split("\\s+,")) {
			StringBuilder tBuilder = new StringBuilder(texts);
			System.out.println(tBuilder.reverse());
		}
	}

}

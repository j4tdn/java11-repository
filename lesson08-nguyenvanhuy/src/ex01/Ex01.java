package ex01;

public class Ex01 {
	public static void main(String[] args) {
		String s = "Nóng thì ăn kem";

		System.out.println("split characters: ");
		splitChar(s);

		System.out.println("split words: ");
		splitWord(s);
		
		System.out.println("reverse");
		reverseString(s);
	}

	private static void splitChar(String s) {
		for (int i = 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}
	
	private static void splitWord(String s) {
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == ' ') {
				System.out.println();
			}
			System.out.print(s.charAt(i));
		}
		System.out.println();
	}
	
	private static void reverseString (String s) {
		StringBuilder str = new StringBuilder(s);
		System.out.println(str.reverse());
	}
}

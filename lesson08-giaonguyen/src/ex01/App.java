package ex01;

public class App {
	public static void main(String[] args) {
		String str = "Nguyễn Quốc Thanh Giao";
		
		/**
		 * print each character one line
		 */
		
		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != ' ') {
				System.out.println(str.charAt(i));
			}
			else continue;
		}
		
		/**
		 * print each word one line
		 */

		System.out.println("========================");

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != ' ') {
				System.out.print(str.charAt(i));
			}
			else {
				System.out.print("\n");
			}
		}
		
		/**
		 * print each reverse word one line 
		 */

		System.out.println("\n========================");

		StringBuilder strBuff = new StringBuilder();

		for (int i = 0; i < str.length(); ++i) {
			if (str.charAt(i) != ' ') {
				strBuff.append(str.charAt(i));
			}
			else {
				System.out.println(strBuff.reverse());
				strBuff.setLength(0);
			}

			if (i == str.length() - 1) {
				System.out.println(strBuff.reverse());
				strBuff.setLength(0);
			}
		}
	}
}

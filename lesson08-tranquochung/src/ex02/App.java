package ex02;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = "Trần    quốc     HƯng   ";
		while (true) {
			try {
				// String str = scanner.nextLine();
				for (int i = 0; i < str.length(); i++) {
					if ((str.charAt(i) < 'A' && str.charAt(i) > 'Z') || (str.charAt(i) < 'a' && str.charAt(i) > 'z')) {
						throw new RuntimeException();
					}
				}
				break;
			} catch (RuntimeException e) {
				e.getStackTrace();
				System.out.print("Enter String Again: ");
			}
		}
		scanner.close();

		/**
		 * The characters are separated by a space
		 */
		str = str.replaceAll("[\\s]+", " ").trim();
		System.out.println(str);

		/**
		 * UpperCase first each word, the rest are lower case
		 */
		String[] words = str.split("\\s");
		for (int i = 0; i < words.length; i++) {
			words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1, words[i].length()).toLowerCase();
		}
		String strResult = new String().join(" ", words);

		System.out.println(strResult);
	}
}

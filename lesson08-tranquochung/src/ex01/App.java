package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter String: ");
		String str = scanner.nextLine();
		scanner.close();

		/**
		 * print each character per line
		 */
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				continue;
			}
			System.out.println(str.charAt(i));
		}

		System.out.println("==============");

		/**
		 * print each word per line
		 */
		String[] words = str.split("\\s+");
		for (String word : words) {
			System.out.println(word);
		}

		System.out.println("==============");

		/**
		 * print the reversed string by character
		 */
		StringBuilder strBuilder = new StringBuilder(str);
		System.out.println(strBuilder.reverse());

		System.out.println("=============");
		/**
		 * print the reversed string by word
		 */
		for (String word : words) {
			StringBuilder wordStrBuilder = new StringBuilder(word);
			System.out.println(wordStrBuilder.reverse());
		}

	}

}

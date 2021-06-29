package ex01;

import java.util.Scanner;

public class App {

	private static String PATTERN = "^[\\p{L} .'-]+$";

	public static void main(String[] args) {

		while (true) {
			Scanner ip = new Scanner(System.in);
			System.out.print("Enter string: ");
			String s = ip.nextLine();
			if (s.matches(PATTERN)) {
				charPerLine(s);
				wordPerLine(s);
				reverseString(s);
				break;
			} else {
				System.out.println("String contains only Vietnamese characters! Please re-enter!");
			}
		}
	}

	private static void charPerLine(String s) {
		System.out.println("---Each character per line---");

		for (char c : s.toCharArray()) {
			System.out.println(c);
		}
	}

	private static void wordPerLine(String s) {
		System.out.println("---Each word per line---");
		for (String w : s.split("\\s")) {
			System.out.println(w);
		}
	}

	private static void reverseString(String s) {
		System.out.println("---Reverse string by character---");
		for (int i = s.length() - 1; i >= 0; i--) {
			System.out.print(s.charAt(i));
		}

		System.out.println("\n---Reverse string by word---");
		String[] words = s.split("\\s");
		for (int i = words.length - 1; i >= 0; i--) {
			System.out.print(words[i] + " ");
		}
	}
}

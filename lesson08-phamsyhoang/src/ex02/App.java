package ex02;

import java.util.Scanner;

public class App {
	private static String FULL_NAME_PATTERN = "^[\\p{L} .'-]+$";

	public static void main(String[] args) {
		while (true) {
			Scanner ip = new Scanner(System.in);
			System.out.print("Enter full name: ");
			String s = ip.nextLine();
			if (s.matches(FULL_NAME_PATTERN)) {
				convert(s);
				break;
			}
			else {
				System.out.println("Invalid! Please enter again!");
			}
		}
	}

	private static void convert(String s) {
		for (String w : s.split(" ")) {
			String w1 = w.substring(0, 1);
			w1 = w1.toUpperCase();
			String w2 = w.substring(1);
			w2 = w2.toLowerCase();
			System.out.print(w1 + w2 + " ");
		}
	}

}

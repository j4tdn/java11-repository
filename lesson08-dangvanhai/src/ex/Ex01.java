package ex;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter: ");
//		String line = scanner.nextLine();	
		String line = "Bạn có thể chỉ định ngôn ngữ tìm kiếm của mình trong Tùy chọn";
		scanner.close();
		printCharacters(line);
		printWords(line);
		printReverse(line);
	}

	private static void printCharacters(String line) {
		System.out.println("-- Print characters in String --");
		for (char a : line.toCharArray()) {
			System.out.println(a);
		}
	}

	private static void printWords(String line) {
		System.out.println("-- Print words in String");
		for (String a : line.split("\\s+")) {
			System.out.println(a);
		}
	}

	private static void printReverse(String line) {
		System.out.println("-- Print reverse chars --");
		for (char a : (new StringBuilder().append(line).reverse().toString().toCharArray())) {
			System.out.println(a);
		}

		System.out.println("-- Print reverse words --");
		for (String a : line.split("\\s+")) {
			System.out.println((new StringBuilder().append(a).reverse()));
		}
	}
}

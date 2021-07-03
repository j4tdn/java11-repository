package ex06;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		String n = "1234567891011121314";
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		while (true) {
			try {
				System.out.print("Enter Location: ");
				i = Integer.parseInt(scanner.nextLine());
				break;
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		scanner.close();
		System.out.println("Result: " + n.charAt(i - 1));
	}
}

package ex01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex01Main {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.print("Enter a: ");
			int a = getInput();
			System.out.print("Enter b: ");
			int b = getInput();
			try {
				System.out.println("Result = " + (-b / a));
				break;
			} catch (ArithmeticException e) {
				System.out.println(e.getMessage());
				System.out.println("\nEnter again!");
			}
		}
	}

	private static int getInput() {
		int input = 0;
		while (true) {
			try {
				input = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println(e.getMessage());
				System.out.println("Please enter again!");
			}
		}
		return input;
	}
}

package homework;

import java.util.InputMismatchException;
import java.util.Scanner;

// Solve the equation ax + b = 0
public class Exercise1 {
	public static void main(String[] args) {
		int a, b;
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Enter a, b: ");
				a = sc.nextInt();
				b = sc.nextInt();
				if (a == 0) {
					throw new ArithmeticException();
				}
				System.out.println("The solution of equation: x = " + (-1) * b / (float) a);
				return;
			} catch (InputMismatchException e) {
				System.out.println("a or b can not be character!");
				System.out.println("Please enter again!");
				sc.nextLine();
			} catch (ArithmeticException e) {
				System.out.println("a can't equal 0!");
				System.out.println("Please enter again!");
			}
		}

	}

}

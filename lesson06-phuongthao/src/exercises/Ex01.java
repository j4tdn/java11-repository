package exercises;

import java.util.Scanner;
import exception.MyException;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		int a, b;

		while (true) {
			try {
				System.out.print("Enter a = ");
				a = Integer.parseInt(ip.nextLine());
				System.out.print("Enter b = ");
				b = Integer.parseInt(ip.nextLine());
				System.out.println("result: " + divide(a, b));
				break;
			} catch (MyException e) {
				System.out.println(e.getMessage());
				System.out.println("Enter again ");
				System.out.println("=====================");
			}
		}

	}

	private static double divide(int a, int b) throws MyException {
		if (a == 0) {
			throw new MyException("Please enter a non-zero value");
		}
		return -(double)b / a;
	}
}

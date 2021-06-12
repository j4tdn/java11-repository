package exercises;

import java.util.Scanner;


public class Ex01 {

	public static void main(String[] args) {
		float a = 0, b = 0, c = 0;
		a = typeNumber();
		b = typeNumber();
		equation(a, b);
	}

	public static float typeNumber() {
		float a = 0;
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.println("Enter the value of number");
			try {
				a = Integer.parseInt(sc.nextLine());
				check = false;
			} catch (NumberFormatException e) {
				System.out.println("The type of character which you've type isn't digit, please type again!");
				check = true;
			}
		} while (check);
		return a;
	}

	public static void equation(float a, float b) {
		
		try {
			float c = -b / a;
			System.out.println(c);
			System.out.println("argument of the equation: " + a + "x+" + b + "=0 la x=" + c);
		} catch (ArithmeticException e) {
			System.out.println("a=0, not satisfy the problem");
		}

	}

}
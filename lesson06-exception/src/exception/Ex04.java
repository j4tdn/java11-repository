package exception;

import java.util.Scanner;

public class Ex04 {
	private static Scanner ip = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter a: ");
		int a = Integer.parseInt(ip.nextLine());

		System.out.println("Enter b: ");
		int b = Integer.parseInt(ip.nextLine());
		
		try {
			int x = div(a, b);
			System.out.println("Result: " + x);
		} catch (Exception e) {
		System.out.println("--- Jump to catch ---");
		}
		System.out.println("Thread main end !");
	}

	private static int div(int a, int b) {
		//Root cause: a = 0
		if(a==0)
		{
			System.out.println("Throw exception");
			throw new ArithmeticException();
		}
		System.out.println("-b/a");
		return -b / a;
	}
}

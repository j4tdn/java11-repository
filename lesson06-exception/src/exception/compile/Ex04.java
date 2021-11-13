package exception.compile;

import java.util.Scanner;

import exception.own.DivideByZeroException;

public class Ex04 {
	private static Scanner ip = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Enter a: ");
		int a = Integer.parseInt(ip.nextLine());
		System.out.println("Enter b: ");
		int b = Integer.parseInt(ip.nextLine());
		int x = div(a,b);
		System.out.println("Result: "+x);
	}
	private static int div(int a, int b)
	{
		if(a==0)
		{
			System.out.println("throw Exception");
			throw new DivideByZeroException();
		}
		System.out.println("-b/a");
		return -b/a;
	}
}

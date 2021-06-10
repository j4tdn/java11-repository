package ex01;

import java.util.Scanner;

public class FirstDgreeEquation {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Result First Degree Equation ax+b =0");
		 
		 int b = 0;
		 int a = 0;
		 while (true) {
			try {
				System.out.println("Enter A: ");
				a = Integer.parseInt(ip.nextLine());
				
				System.out.println("Enter B: ");
				b = Integer.parseInt(ip.nextLine());
				
				 System.out.println("Result X: " + Equation(a, b));
				break;
			} catch (NumberFormatException e) {
				System.out.println("You type wrong. Please try enter again");
			}
			catch (ArithmeticException e) {
				System.out.println("You typed 0 number. Please try enter again");
			}
	}
		System.out.println("main end");
	}
	private static float Equation(float a, float b)  {
		
		if(a == 0) {
			throw new ArithmeticException();
		}
		return  -b/a;
		
	}
	
}

package Ex01;

import java.util.Scanner;

import exception.ZeroException;

public class equation {
	public static void main(String[] args) {
		System.out.println("Solve first degree equation");
		Scanner ip = new Scanner(System.in);
		
		int a = 4;
		int b = 8;
		while (true) {
			try {
				System.out.print("Input a: ");
				a = Integer.parseInt(ip.nextLine());
				System.out.print("Input b: ");
				b = Integer.parseInt(ip.nextLine());
				break;
				
			} catch (NumberFormatException e) {
				System.out.println("Invalid number, please input the number");
			}
			
		}

		System.out.println("===============");
		
		if (a == 0) {
			try {
				System.out.println("    "+a +"x + "+ b + " = 0 \n<=> x = " + -b +"/"+a 
						+ "\n<=> x = " + solveEquation(a, b));	
			} catch (ZeroException e) {
				System.out.println(e.fillInStackTrace());
			}	
		} else
			System.out.println("    "+a +"x + "+ b + " = 0 \n<=> x = " + -b +"/"+a 
					+ "\n<=> x = " + solveEquation(a, b));
			
	}
	
	public static float solveEquation(int a, int b) throws ArithmeticException {
		if (a == 0) {
			throw new ZeroException("Please enter a value different 0");
		}
		return -b/a;
	}
}

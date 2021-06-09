package ex01;

import java.util.Scanner;

import exception.ZeroException;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Giai PT bac 1 ax + b = 0 ");
		try {
			System.out.println("Nhap a: ");
			int  a = Integer.parseInt(sc.nextLine());
			 System.out.println("Nhap b: ");
			 int b = Integer.parseInt(sc.nextLine());
			 try {
			 System.out.println("x = "+ ptb1(a,b));}
			 catch(ZeroException e) {
				 System.out.println("Div by zero. Please again! ");
			 }
			 
		} catch (NumberFormatException e) {
			System.out.println("Not number");
		}
			
	}
	private static double ptb1(double a, double b) throws ZeroException {
		if(a ==0 ) {
			throw new ZeroException("Div by Zero");
		}
		else return -b/a;
	}

}

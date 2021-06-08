package Bai01;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		System.out.println("tinh phuong trinh ax + b = 0");
		double a = 0;
		double b = 0;
		while(true) {
			try {
				Scanner ip = new Scanner(System.in);
				System.out.println("nhap a: ");
				a = Integer.parseInt(ip.nextLine());
				System.out.println("nhap b: ");
				b = Integer.parseInt(ip.nextLine());
				break;
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				System.out.println("ban phai nhap vao mot so !!! ");
			}
		}
		
		System.out.println("x = " + -b/a);
	}
}

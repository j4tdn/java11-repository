package exercises;

import java.util.Scanner;

public class Ex01 {
	
	private static Scanner ip = new Scanner(System.in);
	
	public static void main(String[] args) {
		// ax + b = 0;
		int a = 0;
		int b = 0;
		
		while(true) {
			try {
				System.out.print("Enter a: ");
				a = Integer.parseInt(ip.nextLine());
				if (a != 0) {
					break;
				}
				System.out.println("Enter a != 0");
			} catch (Exception e) {
				System.out.println("Enter valid number !");
			}
		}
		
		while(true) {
			try {
				System.out.print("Enter b: ");
				b = Integer.parseInt(ip.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Enter valid number !");
			}
		}
		
		int x = -b/a;
		
		System.out.println("x: " + x);
		
	}
}

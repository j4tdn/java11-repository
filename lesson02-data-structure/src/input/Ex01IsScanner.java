package input;

import java.util.Scanner;

public class Ex01IsScanner {
	public static void main(String[] args) {
		// trôi lệnh
		// Trước: Nhập vào input kiểu khác String
		// Sau: Nhập vào input là String

		Scanner ip = new Scanner(System.in);

		System.out.print("Enter name: ");
		String name = ip.nextLine();

		System.out.print("Enter age: ");
		//int age = ip.nextInt(); 
		// Cách 1: ip.nextLine();
		
		int age = Integer.parseInt(ip.nextLine());
		
		

		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();

		System.out.println("Name: " + name);

		System.out.println("Is Empty: " + name.isEmpty());

		System.out.println("Age: " + age);

		System.out.println("Hobbies: " + hobbies);
	}

}

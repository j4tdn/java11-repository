package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		// Troi lenh
		// Truoc: Nhap vao input la mot kieu khac String
		// Sau: Nhap vao input la String
		
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = ip.nextLine();
		System.out.print("Enter age: ");
		//int age = ip.nextInt();  ip.nextLine(); // Sua loi troi lenh
		int age = Integer.parseInt(ip.nextLine());
		
		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.println("Name: " + name);
		System.out.println("isEmpty: " + name.isEmpty());
		System.out.println("Age: " + age);
		System.out.println("Hobby: " + hobbies);
	}
	
}

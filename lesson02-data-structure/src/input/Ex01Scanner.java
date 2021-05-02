package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		// Troi lenh
		// truoc : nhap vao input 1 kieu khac String
		// sau : nhap vao input la String.

		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name : ");
		String name = ip.nextLine();

		System.out.print("Enter age : ");
		// int age = ip.nextInt();
		// ip.nextLine(); // chan troi lenh
		int age = Integer.parseInt(ip.nextLine());

		System.out.print("Enter hobbies : ");
		String hobbies = ip.nextLine();

		System.out.println("================");
		System.out.println("name : " + name);
		System.out.println("isEmpty : " + name.isEmpty());
		System.out.println("age : " + age);
		System.out.println("hobbies : " + hobbies);
	}
}

package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		// Trôi lệnh:
		// Trước: nhập vào input là 1 kiểu khác String (ex: int, fload, double..)
		// Sau: nhập vào input là 1 String

		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = ip.nextLine();

		System.out.print("Enter age: ");
		// int age = ip.nextInt(); ip.nextLine();
		int age = Integer.parseInt(ip.nextLine());
				
		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();

		System.out.println("Name: " + name);
		System.out.println("Name isEmpty: " + name.isEmpty());

		System.out.println("Age: " + age);
		System.out.println("Hobbies: " + hobbies);
	}
}

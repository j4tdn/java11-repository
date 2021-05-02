package input;

import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		// Trôi lệnh
		// Trước: Nhập vào input khác kiểu String
		// Sau: Nhập vào input là String
		
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = ip.nextLine();
		System.out.println("Name: " + name);
		
		System.out.print("Enter age: ");
		int age = Integer.parseInt(ip.nextLine());
		
		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.println("IsEmpty: " + name.isEmpty());
	}
}

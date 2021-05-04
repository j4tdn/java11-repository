package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		// trôi lệnh 
		// trước: nhập vào input là 1 kiểu khác String
		// sau: nhập vào input là 1 String
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Enter name: ");
		String name = ip.nextLine();
		
		System.out.print("Enter age: ");
		//int age = ip.nextInt(); ip.nextLine();
		int age = Integer.parseInt(ip.nextLine());
		
		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();
					
		System.out.println("Name: " + name);
		System.out.println("IsEmpty: " + name.isEmpty());
		System.out.println("Age: " + age);
		System.out.println("Hobbies: " + hobbies);	
	}

}

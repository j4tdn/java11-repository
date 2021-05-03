package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
<<<<<<< HEAD
		//troi lenh
		//truoc: nhap vao input la 1 kieu khac String
		//sau: nhap vao input la String
=======
		// Troi lenh
		// Truoc: Nhap vao input la mot kieu khac String
		// Sau: Nhap vao input la String
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
		
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = ip.nextLine();
<<<<<<< HEAD
		
		System.out.print("Enter age: ");
		//int age = ip.nextInt(); ip.nextLine();
		int age = Integer.parseInt(ip.nextLine());
		
		System.out.println("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.println("Name: " + name);
		System.out.println("IsEmpty: " + name.isEmpty());
		System.out.println("Age: " + age);
		System.out.println("Hobbies: " + hobbies);
	}
=======
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
	
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
}

package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		// Trôi lệnh 
		// Trước: Nhập vào iput là 1 kiểu khác String 
		// Sau : NHập vào input là string
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Enter name: " );
		String name = ip.nextLine();
		
		System.out.println("Enter age: ");
		int age  = Integer.parseInt(ip.nextLine());
		
		System.out.println("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.println(" Name: " +name);
		System.out.println("Is Empty: "+ name.isEmpty());
		System.out.println("Age: "+age);
		System.out.println("Hobbies: " + hobbies);
	}

}

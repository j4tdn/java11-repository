package input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = ip.nextLine();	
		
		System.out.print("Enter age: "); 
		// Fix trôi lệnh, cách 1
		// int age = ip.nextInt(); ip.nextLine(); // tại đây sẽ dư kí tự enter (chuỗi rỗng) nên phải lưu enter vào ip.nextLine()
		int age = Integer.parseInt(ip.nextLine()); 
		
		// Trôi lệnh
		// Trước: Nhập vào input la 1 kiểu khác String
		// Sau: Nhập vào input là string
		System.out.print("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.println("Name: " + name);
		System.out.println("IsEmpty: " + name.isEmpty());
		System.out.println("Age: " + age);	
		System.out.println("Hobbies: " + hobbies);	
	}
}

package input;

import java.util.Scanner;

public class Ex01 {
   public static void main(String[] args) {
	//trôi lệnh
	//trước: nhập vào input là 1 kiểu khác string
	//sau: nhập vào input là kiểu string
	
	
	Scanner ip = new Scanner(System.in);
	System.out.print("Enter name: ");
	String name = ip.nextLine();
	
	System.out.println("Enter age: ");
	int age = Integer.parseInt(ip.nextLine());
	
	System.out.print("Enter hobbies: ");
	String hobbies = ip.nextLine();
	
	System.out.println("Name: " + name);
	System.out.println("Age: " + age);
	System.out.println("Hobbies: " + hobbies);
   }
}

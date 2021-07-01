package inpput;

import java.util.Scanner;

public class Ex02Scanner {
	public static void main(String[] args) {
	
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter fullname: ");
		String fullname = ip.nextLine();
		
		System.out.println("Enter age: ");
		int age = Integer.parseInt(ip.nextLine());
		//ip.nextInt(): has redundant enter
		// ip.nextLine: not
		
		System.out.println("Enter hobbies: ");
		String hobbies = ip.nextLine();
		
		System.out.println("Enter Address: ");
		String address = ip.nextLine();
		
		System.out.println("fullname: "+fullname);
		System.out.println("age: "+age);
		System.out.println("hobbies: "+hobbies);
		System.out.println("address: "+address);
		
	}
}

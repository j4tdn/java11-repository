package Input;

import java.util.Scanner;

public class Ex01Scanner {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter fullname: ");
		String name = ip.nextLine();
		System.out.println("Enter Age: ");
		int age = Integer.parseInt(ip.nextLine());
		System.out.println("Enter hobbies: ");
		String hobbies = ip.nextLine();
		System.out.println("name: "+name);
		System.out.println("age: "+age);
		System.out.println("hobbies: "+hobbies);
	}
}

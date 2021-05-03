package input;
import java.util.*;
public class Ex01Scanner {
	public static void main(String[] args) { 
		// Trôi lệnh
		// Trước: Nhập vào input là 1 kiểu khác String 
		// Sau: Nhập vào input là String
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter name: ");
		String name = ip.nextLine();
		
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
}

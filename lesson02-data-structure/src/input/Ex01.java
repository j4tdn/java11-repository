package input;

import java.util.Scanner;

public class Ex01 {
 public static void main(String[] args) {
	 //Trôi lệnh
	 //Trước: nhập vào i là 1 kiểu khác 
	 //Sau: nhập input là 
    Scanner ip = new Scanner(System.in);
    System.out.print("Enter name: ");
    String name = ip.nextLine();
    
    System.out.print("Enter age: ");
    //int age = int.nextInt(); ip.nextLine();
    int age =  Integer.parseInt(ip.nextLine());
    
    System.out.print("Enter hobbies: ");
    String hobbies = ip.nextLine();
    
    
    
  
    
    
    System.out.println("Name: " + name);
    System.out.println("IsEmpty: " + name.isEmpty());
    System.out.println("Age: " + age);
    System.out.println("Hobbies: " + hobbies);
    		
 }
}

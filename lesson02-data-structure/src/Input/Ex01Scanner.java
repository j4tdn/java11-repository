package Input;

import java.util.Scanner;

public class Ex01Scanner {
     public static void main(String[] args) {
    	 //Trôi lệnh nếu
    	 //Trước: Nhập vào input là 1 kiểu khác String
    	 //Sau: Nhập vào input là String
    	 
    	 //Khai báo 1 biến scanner
    	 Scanner ip = new Scanner(System.in);
    	 
    	 System.out.println("Enter name: ");
    	 String name = ip.nextLine();
    	 
    	 System.out.println("Enter page: ");
    	 //int age = ip.nextInt(); ip.nextLine(); //bt kiểm tra input đầu vào
    	 int age = Integer.parseInt(ip.nextLine());
    	 
    	 
    	 System.out.println("Enter hobbies: ");
    	 String hobbies = ip.nextLine();
    	 
    	 
    	 System.out.println("Name: " + name);
    	 System.out.print("IsEmpTy" + name.isEmpty());
    	 System.out.println("Age: "+ age);
    	 System.out.println("Hobbies: "+ hobbies);
     }
}

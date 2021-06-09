package ex02;

import java.util.Scanner;

public class Ex02 {
   public static void main(String[] args) {
	Scanner ip = new Scanner(System.in);
	while(true) {
	try {
		System.out.print("Nhap pass: ");
		String pass = ip.nextLine();
		test(pass);
		System.out.println("Nhap thanh cong !!!");
		break;
	} catch (PasslException e) {
		System.out.println(e.getMessage());
	}
	}
}
   public static void test(String ip) {
	   if(ip.length() < 8 || ip.length() > 256) {
		   throw new PasslException("Nhap it nhat 8 ky tu va nhieu nhat 256 ky tu");
	   }
	   
   }
}

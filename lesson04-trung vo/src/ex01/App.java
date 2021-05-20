package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		Student s1 = new Student(1,"VO DINH TRUNG", 8.5f, 8f);
		Student s2 = new Student(2, "Harry Potter", 9f, 10f);
		
		System.out.println("ID \t Name \t\t DIEM LI THUYET \t DIEM THUC HANH \t DIEM TB");
		System.out.println("====================================");
		System.out.println(s1);
		System.out.println(s2);
	
		System.out.println("nhap vao thong tin sinh vien :");
		Student s3 = new Student();
		System.out.println("nhap id: ");
		s3.setId(ip.nextInt());
		ip.nextLine();

		System.out.println("nhap ho va ten: ");
		s3.setName(ip.nextLine());
	
		System.out.println("nhap diem li thuyet: ");
		s3.setLt(ip.nextFloat());
		System.out.println("nhap diem thuc hanh: ");
		s3.setTh(ip.nextFloat());

		System.out.println(s3);
	
	}
}

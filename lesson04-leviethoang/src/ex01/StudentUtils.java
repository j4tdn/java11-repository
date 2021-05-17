package ex01;

import java.util.Scanner;

public class StudentUtils {
	private StudentUtils() {
		
	}
	
	public static void inputStudent(Student student) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap ma sinh vien : ");
		student.setId(ip.nextInt());
		ip.nextLine();
		System.out.print("Nhap ho ten :");
		student.setName(ip.nextLine());
		System.out.print("Nhap diem LT : ");
		student.setLT(ip.nextFloat());
		System.out.print("Nhap diem TH : ");
		student.setTH(ip.nextFloat());
	}
	
	public static double score(Student student) {
		double average = 0;
		average = (student.getLT() + student.getTH()) / 2;
		return average;
	}
	
	
}

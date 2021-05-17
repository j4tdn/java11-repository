package ex01;

import java.util.Scanner;

public class Ex01Main {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);

		Student sv1 = new Student(01, "Le Van A", 8, 6);
		Student sv2 = new Student(02, "Le Van B", 7, 3);
		Student sv3 = new Student();
		StudentUtils.inputStudent(sv3);

		
		System.out.println("================================================");
		
		System.out.println("MSV\t Ten\t\t\t LT\t TH\t DTB");
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}
}

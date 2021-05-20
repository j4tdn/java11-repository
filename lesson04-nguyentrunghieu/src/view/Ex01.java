package view;

import java.util.Scanner;

import bean.Student;

public class Ex01 {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Nguyen Trung Hieu", 8.0f, 8.0f);
		Student s2 = new Student(2, "Hoang Thai Son", 8.0f, 8.0f);
		Student s3 = new Student();
		input(s3);

		System.out.println("=============================");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

	private static void input(Student student) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap ma so sinh vien: ");
		student.setId(Integer.parseInt(sc.nextLine()));

		System.out.print("Nhap ho ten: ");
		student.setFullName(sc.nextLine());
		System.out.print("Nhap diem ly thuyet: ");
		student.setdiemLT(Float.parseFloat(sc.nextLine()));
		System.out.print("Nhap diem thuc hanh: ");
		student.setdiemTH(Float.parseFloat(sc.nextLine()));

		sc.close();
	}

}

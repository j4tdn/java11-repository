package Ex01;

import java.util.Scanner;

public class Ex01App {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Nguyen Van A", 8.5f, 9.2f);
		Student s2 = new Student(2, "Nguyen Van B", 8.4f, 9.5f);
		Student s3 = new Student();
		inputInfoStudent(s3);

		System.out.println("=============");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

	private static void inputInfoStudent(Student student) {
		Scanner scanner = new Scanner(System.in);

		// Enter id for student
		System.out.print("Nhap ma so sinh vien: ");
		student.setIdStudent(scanner.nextInt());
		scanner.nextLine(); // ignore the newline character

		// Enter name and score
		System.out.print("Nhap ho ten: ");
		student.setFullName(scanner.nextLine());
		System.out.print("Nhap diem ly thuyet: ");
		student.setTheoryScore(scanner.nextFloat());
		System.out.print("Nhap diem thuc hanh: ");
		student.setPracticeScore(scanner.nextFloat());

		scanner.close();
	}
}

package ex01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		Student s1 = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student's id 1: ");
		s1.setId(sc.nextInt());sc.nextLine();
		System.out.println("Enter student's name: ");
		s1.setName(sc.nextLine());
		System.out.println("Enter theory point: ");
		s1.setTheoryPoint(sc.nextFloat());
		System.out.println("Enter practical point: ");
		s1.setPracticalPoint(sc.nextFloat());

		Student s2 = new Student();
		System.out.println("Enter student's id 2: ");
		s2.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter student's name: ");
		s2.setName(sc.nextLine());
		System.out.println("Enter theory point: ");
		s2.setTheoryPoint(sc.nextFloat());
		System.out.println("Enter practical point: ");
		s2.setPracticalPoint(sc.nextFloat());

		Student s3 = new Student();
		System.out.println("Enter student's id 3: ");
		s3.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Enter student's name: ");
		s3.setName(sc.nextLine());
		System.out.println("Enter theory point: ");
		s3.setTheoryPoint(sc.nextFloat());
		System.out.println("Enter practical point: ");
		s3.setPracticalPoint(sc.nextFloat());
		//in theo format
        System.out.printf("%5s %6s %6s %15s %6s \n","id","name","theoryPoint","practicalPoint","avaragePoint");
        //gọi phương thức in đã được viết ở class SinhVien cho các sinh viên để hiển thị kết quả đã nhập
        s1.printStudent();
        s2.printStudent();
        s3.printStudent();
 

	}

}

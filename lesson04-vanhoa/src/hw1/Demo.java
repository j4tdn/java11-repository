package hw1;

import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {

		Student st1 = new Student(7643, "Le Van Hoa", 9.9f, 9.8f);
		Student st2 = new Student(5678, "Le Van Teo", 1.1f, 3.9f);
		Student st3 = new Student();
		input(st3);

		System.out.printf("\n%-12s%-15s%20s%25s%15s\n", "ID", "Name", "Theoretical Grade", "Practise Grade", "Average");
		System.out.println("=========================================================================================");
		System.out.printf("%-12d%-15s%20.2f%25.2f%15.2f\n", st1.getId(), st1.getName(), st1.getTrGrade(),
				st1.getPrGrade(), st1.avgGrade());
		System.out.printf("%-12d%-15s%20.2f%25.2f%15.2f\n", st2.getId(), st2.getName(), st2.getTrGrade(),
				st2.getPrGrade(), st2.avgGrade());
		System.out.printf("%-12d%-15s%20.2f%25.2f%15.2f\n", st3.getId(), st3.getName(), st3.getTrGrade(),
				st3.getPrGrade(), st3.avgGrade());
	}

	public static Student input(Student student) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter id: ");
		int id = Integer.parseInt(sc.nextLine());
		student.setId(id);

		System.out.print("Enter name: ");
		String name = sc.nextLine();
		student.setName(name);

		System.out.print("Enter Theoretical Grade: ");
		float x = Float.parseFloat(sc.nextLine());
		student.setPrGrade(x);

		System.out.print("Enter Practise Grade: ");
		float y = Float.parseFloat(sc.nextLine());
		student.setTrGrade(y);

		return student;
	}
}

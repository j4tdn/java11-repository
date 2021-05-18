package exercises;

import java.util.Scanner;

import entities.Student;

public class Ex01_studentMangement {
	public static void main(String[] args) {

		Student sv1 = new Student(122180038, "Thao", 7.7f, 7.8f);
		Student sv2 = new Student(122180032, "Huy", 8.2f, 9f);
		Student sv3 = new Student();
		
		//input(sv3);

		System.out.printf("%-20s %-15s %-20s %-20s %-17s\n", "MSSV", "name", "theoretical score", "practice score",
				"medium score");
		System.out.println(
				"============================================================================================");
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);

	}

	public static Student input(Student sv) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter MSSV: ");
		sv.setMSSV(Integer.parseInt(ip.nextLine()));
		System.out.println("Enter name: ");
		sv.setName(ip.nextLine());
		System.out.println("Enter theoretical score: ");
		sv.settheoreticalScore(Float.parseFloat(ip.nextLine()));
		System.out.println("Enter practice score: ");
		sv.setpracticeScore(Float.parseFloat(ip.nextLine()));

		return sv;

	}

}

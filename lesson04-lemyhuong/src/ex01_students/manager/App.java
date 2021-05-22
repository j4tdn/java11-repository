package ex01_students.manager;

import java.util.Scanner;

public class App {
	

	public static void main(String[] args) {
		
		Student s1 = new Student(01, "Adam", 7.5f, 7.0f);
		Student s2 = new Student(02, "Eva", 8.5f, 7.2f);
		Student s3 = new Student();
		input(s3);
		
		System.out.println("============================");
		
		System.out.println("\t"+"ID"+"\t"+"NAME"+"\tTHEORY SCORE"+"\tPRACTICE SCORE" + "\tAVARAGE");
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
	}
	
	public static void input(Student student) {
		Scanner ip = new Scanner(System.in);
		
		System.out.print("Input student id: ");
		student.setId(Integer.parseInt(ip.nextLine()));
		
		System.out.print("Input student name: ");
		student.setName(ip.nextLine());
		
		System.out.print("Input theory score: ");
		student.setTheoryScore(Float.parseFloat(ip.nextLine()));
		
		System.out.print("Input practice score: ");
		student.setPracticeScore(Float.parseFloat(ip.nextLine()));
	}

}

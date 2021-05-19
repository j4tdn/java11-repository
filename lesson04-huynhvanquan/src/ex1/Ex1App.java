package ex1;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex1App {
	final static int SPACE = 10;
	public static void main(String[] args) {
		Student s1 = new Student(1, "Nguyen A", 10, 10);
		Student s2 = new Student(2, "Nguyen B", 9, 9);
		Student s3 = new Student();
		ArrayList<Student> studentList = new ArrayList<Student>();
		setInfo(s3);
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);		
		printStudentList(studentList);
	}
	private static void  setInfo(Student s) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id: ");
		s.setId(sc.nextInt());
		System.out.print("Enter name: ");
		sc.nextLine();
		s.setName(sc.nextLine());
		System.out.println("Enter theoretical point: ");
		s.setTheorPoint(sc.nextFloat());
		System.out.println("Enter practical point: ");
		s.setPractPoint(sc.nextFloat());
	}
	private static void printStudentList(ArrayList<Student> studentList) {
		printTitle();
		System.out.println("");
		for(int i = 0; i < studentList.size(); i++) { 
			System.out.print(studentList.get(i).getId());
			printSpace(SPACE + "Id".length() - String.valueOf(studentList.get(i).getId()).length());
			System.out.print(studentList.get(i).getName());
			printSpace(SPACE + "Name".length() - String.valueOf(studentList.get(i).getName()).length());
			System.out.print(studentList.get(i).getTheorPoint());
			printSpace(SPACE + "TheorPoint".length() - String.valueOf(studentList.get(i).getTheorPoint()).length());
			System.out.print(studentList.get(i).getPractPoint());
			printSpace(SPACE + "PractPoint".length() - String.valueOf(studentList.get(i).getPractPoint()).length());
			System.out.println(studentList.get(i).averagePoint());	
		}
	}
	private static void printTitle() {
		printSpace(20);
		System.out.println("STUDENT MANAGEMENT SYSTEM");
		System.out.print("Id");
		printSpace(SPACE);
		System.out.print("Name");
		printSpace(SPACE);
		System.out.print("TheorPoint");
		printSpace(SPACE);
		System.out.print("PractPoint");
		printSpace(SPACE);
		System.out.println("AverPoint");
		for(int i = 0; i < 75; i++) {
			System.out.print("-");
		}
	}
	private static void printSpace(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(" ");
		}
	}
}

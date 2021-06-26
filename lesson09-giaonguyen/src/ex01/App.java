package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Student[] students = {new Student(102, "Nam", "C"),
				              new Student(104, "Hoàng", "D"),
				              new Student(109, "Lan", "A"),				              
				              new Student(103, "Bảo", "F"),
				              new Student(105, "Nguyên", "B"),
				              new Student(107, "Vũ", "F"),
				              new Student(103, "Bảo", "F"),
				              new Student(202, "Đạt", "C"),
				              new Student(107, "Vũ", "C"),
				              new Student(193, "Bảo", "B"),
				              new Student(199, "Tài", "A")};
		
		findStudentA(students);
		findStudentReStudy(students);
				
	}
	
	public static void findStudentA(Student[] students) {
		System.out.println("List of students with grade A: ");
		for (Student student: students) {
			if (student.getClassification().equals("A")) {				
				System.out.println(student.getName());
			}
		}
	}
	
	public static void findStudentReStudy(Student[] students) {
		System.out.println("List of students re-study: ");
		String[] str = new String[15];
		int count = 0;
		boolean check = false;
		for (Student student: students) {
			if (student.getClassification().equals("F")) {
				
				for (int i = 0; i < str.length; ++i) {
					if (student.getName().equals(str[i])) {
						check = false;
						break;
					}
					else check = true;
				}
				if (check) str[count++] = student.getName();
			}
		}
		
		String[] result = Arrays.copyOfRange(str, 0, count);
		for (String s: result) {
			System.out.println(s);
		}
	}
}

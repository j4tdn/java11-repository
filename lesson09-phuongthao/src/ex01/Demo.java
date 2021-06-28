package ex01;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		Student[] students = new Student[6];
		students[0] = new Student("102", "Nam", Mark.C);
		students[1] = new Student("104", "Hoàng", Mark.D);
		students[2] = new Student("109", "Lan", Mark.A);
		students[3] = new Student("103", "Bảo", Mark.F);
		students[4] = new Student("105", "Nguyên", Mark.B);
		students[5] = new Student("107", "Vũ", Mark.F);

		Student[] studentsA = getStudents(students, t -> t.getMark() == Mark.A);
		showStudents(studentsA);

		Student[] studentsStudyAgain = getStudents(students, t -> t.getMark() == Mark.F);
		showStudents(studentsStudyAgain);

	}

	public static Student[] getStudents(Student[] students, Condition condition) {
		Student[] result = new Student[students.length];
		int k = 0;
		for (Student student : students) {
			if (condition.check(student)) {
				result[k] = student;
				k++;
			}
		}
		return Arrays.copyOfRange(result, 0, k);
	}

	public static void showStudents(Student[] result) {
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}

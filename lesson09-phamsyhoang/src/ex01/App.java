package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Student[] students =getAll();
		Student[] studentA = getStudent(students, Grade.A);
		show(studentA);
	}

	private static Student[] getStudent(Student[] students, Grade grade) {
		Student[] result = new Student[students.length];
		int i = 0;
		for (Student student : students) {
			if (student.getGrade().equals(Grade.A)) {
				result[i++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}

	private static void show(Student[] students) {
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	private static Student[] getAll() {
		Student s1 = new Student("102", "Nam", Grade.C);
		Student s2 = new Student("104", "Hoàng", Grade.D);
		Student s3 = new Student("109", "Lan", Grade.A);
		Student s4= new Student("103", "Bảo", Grade.F);
		Student s5 = new Student("105", "Nguyên", Grade.B);
		Student s6 = new Student("107", "Vũ", Grade.F);
		Student s7 = new Student("103", "Bảo", Grade.F);
		Student s8 = new Student("202", "Đạt", Grade.C);
		Student s9 = new Student("107", "Vũ", Grade.C);
		Student s10 = new Student("193", "Bảo", Grade.B);
		Student s11 = new Student("104", "Hoàng", Grade.B);
		return new Student[]{s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11};
		
	}

}

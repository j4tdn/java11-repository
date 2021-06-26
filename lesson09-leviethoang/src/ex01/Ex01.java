package ex01;

import java.util.Arrays;

public class Ex01 {
	public static void main(String[] args) {
		Student[] students = getStudents();
		Student[] pointA = getStudent(students);
		printStudents(pointA);
		System.out.println("==========================");
		Student[] result = getStudentF(students);
		printStudents(result);
	}

	private static Student[] getStudents() {
		return new Student[] { new Student(102, "Nam", "C"), new Student(104, "Hoang", "D"),
				new Student(109, "Lan", "A"), new Student(103, "Bao", "F"), new Student(105, "Nguyen", "B"),
				new Student(107, "Vu", "F"), new Student(103, "Bao", "F"), new Student(202, "Dat", "C"),
				new Student(107, "Vu", "C"), new Student(193, "Bao", "B"), new Student(104, "Hoang", "B"), };
	}

	private static void printStudents(Student[] students) {
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static Student[] getStudent(Student[] students) {
		Student[] result = new Student[students.length];
		int i = 0;
		for (Student student : students) {
			if (student.getPoint().toUpperCase() == "A") {
				result[i++] = student;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}

	private static Student[] getStudentF(Student[] students) {
		Student[] result = new Student[students.length];
		int index = 0;
		boolean[] flags = new boolean[students.length];
		for (int i = 0; i < students.length - 1; i++) {
			for (int j = 0; j < students.length; j++) {
				if (i != j && students[i].getId() == students[j].getId()) {
					flags[i] = true;
					flags[j] = true;
				}
			}
		}

		for (int i = 0; i < flags.length; i++) {
			for (int j = i + 1; j < flags.length; j++) {
				if (flags[i] && students[i].getId() == students[j].getId()) {
					result[index++] = students[i];
					flags[j] = false;
				}
			}

		}
		return Arrays.copyOfRange(result, 0, index);
	}
}

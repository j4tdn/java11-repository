package ex01;

import java.util.Arrays;

public class Ex01Main {
	public static void main(String[] args) {
		Student[] students = { new Student("102", "Nam", Equivalent.C), new Student("104", "Hoàng", Equivalent.D),
				new Student("109", "Lan", Equivalent.A), new Student("103", "Bảo", Equivalent.F),
				new Student("105", "Nguyên", Equivalent.B), new Student("107", "Vũ", Equivalent.F),
				new Student("103", "Bảo", Equivalent.F), new Student("202", "Đạt", Equivalent.C),
				new Student("107", "Vũ", Equivalent.C), new Student("193", "Bảo", Equivalent.B),
				new Student("104", "Hoàng", Equivalent.B) };

		System.out.println("Danh sách sinh viên từng đạt loại A trong năm 2021.");
		Student[] s1 = getStudents(students, Equivalent.A);
		printStudents(s1);

		System.out.println("\nDanh sách sinh viên tham gia học lại môn cấu trúc dữ liệu trong năm 2021.");
		Student[] s2 = getStudents(students);
		printStudents(s2);
	}

	private static void printStudents(Student[] student) {
		for (Student i : student) {
			System.out.println(i);
		}
	}

	private static Student[] getStudents(Student[] students, Equivalent equivalent) {
		Student[] result = new Student[students.length];
		int index = 0;
		for (Student s : students) {
			if (s.getEquivalent() == equivalent) {
				result[index++] = s;
			}
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static Student[] getStudents(Student[] students) {
		Student[] result = new Student[students.length];
		int count =0;
		int index =0;
		for(Student s : students) {
			if(contains(result, s)) {
				continue;
			}
			for(Student i : students) {
				if(s.equals(i)) {
					count++;
				}
			}
			if(count==2) {
				result[index++] = s;
			}
			count =0;
		}
		return Arrays.copyOfRange(result, 0, index);
	}

	private static boolean contains(Student[] students, Student student) {
		if(students.length == 0 || student == null) {
			return false;
		}
		for (Student s : students) {
			if(s == null ) {
				break;
			}
			if (student.equals(s)) {
				return true;
			}
		}
		return false;
	}
}

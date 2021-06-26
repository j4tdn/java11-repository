package ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Student[] students = input();
		Student[] result1 = findALevel(students);
		Student[] result2  = findStudentStudyAgain(students);
		
		System.out.println("DANH SACH SINH VIEN TUNG DAT LOAI A 2020");
		System.out.println("----------------------------------------");
		for(Student s: result1) {
			System.out.println(s.toString());
		}
		
		System.out.println("\nDANH SACH SINH VIEN HOC LAI MON CTDL 2020");
		System.out.println("----------------------------------------");
		for(Student s: result2) {
			System.out.println(s.toString());
		}
		
		
		
 	}
	private static Student[] findALevel(Student[] students) {
		Student[] result = new Student[students.length];
		int i = 0;
		for (Student s: students) {
			if(s.getLevel() == Level.A) {
				result[i++] = s;
			}
		}
		return Arrays.copyOfRange(result, 0, i);
	}
	
	private static Student[] findStudentStudyAgain(Student[] students) {
		Student[] result = new Student[students.length];
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			for(int j = i + 1; j < students.length; j++) {
				if(students[i].getId() == students[j].getId() && !findElement(result, students[i])) {
					result[count++] = students[i];
				}

			}
		}
		return Arrays.copyOfRange(result, 0, count);
	}
	private static boolean findElement(Student[] students, Student student) {
		for(Student s: students) {
			if(s != null && s.getId() == student.getId()) {
				return true;
			}
		}
		return false;
	}
	
	
	private static Student[] input() {
		return new Student[] {
			new Student(102, "Nam",   Level.C),
			new Student(104, "Hoàng", Level.D),
			new Student(109, "Lan",   Level.A),
			new Student(103, "Bảo",   Level.F),
			new Student(105, "Nguyên",Level.B),
			new Student(107, "Vũ",    Level.F),
			new Student(103, "Bảo",   Level.F),
			new Student(202, "Đạt",   Level.C),
			new Student(107, "Vũ",    Level.C),
			new Student(193, "Bảo",   Level.B),
			new Student(199, "Tài",   Level.A)};
	}
}

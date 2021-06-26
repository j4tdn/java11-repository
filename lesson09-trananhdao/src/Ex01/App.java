package Ex01;

import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		Student[] students = getAll();
		System.out.println("cau a:");
		
		for (Student student : getA(students)) {
			System.out.println(student);
		}
		System.out.println("cau b:");
		for (Student student : getF(students)) {
			System.out.println(student);
		}

	}

	private static Student[] getAll() {
		Student s1 = new Student(102, "Nam", Enum.C);
		Student s2 = new Student(104, "Hoang", Enum.D);
		Student s3 = new Student(109, "Lan", Enum.A);
		Student s4 = new Student(103, "Bao", Enum.F);
		Student s5 = new Student(105, "Nguyen", Enum.B);
		Student s6 = new Student(107, "Vu", Enum.F);
		Student s7 = new Student(103, "Bao", Enum.C);
		Student s8 = new Student(202, "Dat", Enum.C);
		Student s9 = new Student(193, "Vu", Enum.B);
		Student s10 = new Student(104, "Bao", Enum.B);
		return new Student[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10 };
	}

	private static Student[] getA(Student[] student) {
		Student[] arr = new Student[student.length];
		int i = 0;
		for (Student st : student) {
			if (st.getRate().equals(Enum.A)) {
				arr[i++] = st;
			}
		}
		return Arrays.copyOfRange(arr, 0, i);
	}
	
	private static Student[] getF(Student[] student) {
		Student[] arr = new Student[student.length];
		int i = 0;
		for (Student st : student) {
			if (count(student, st)>=2  || st.getRate().equals(Enum.F)) {
				arr[i++] = st;
			}
		}
		return Arrays.copyOfRange(arr, 0, i);
	}
	public static int count(Student[] students, Student s) {
       
		
		int count = 0;
        for (Student student : students) {
			if(student.getStudentcode() == s.getStudentcode() ) {
				count++;
			}
		}
        return count;
    }

}

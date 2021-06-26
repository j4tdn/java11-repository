package ex01;

public class Main {
	public static void main(String[] args) {
		Student student1 = new Student("102", "Nam", Classification.C);
		Student student2 = new Student("104", "Hoàng", Classification.D);
		Student student3 = new Student("109", "Lan", Classification.A);
		Student student4 = new Student("103", "Bảo", Classification.F);
		Student student5 = new Student("105", "Nguyên", Classification.B);
		Student student6 = new Student("107", "Vũ", Classification.F);
		Student student7 = new Student("103", "Bảo", Classification.F);
		Student student8 = new Student("202", "Đạt", Classification.C);
		Student student9 = new Student("107", "Vũ", Classification.C);
		Student student10 = new Student("193", "Bảo", Classification.B);
		Student student11 = new Student("199", "Tài", Classification.A);
		Student[] students = { student1, student2, student3, student4, student5, student6, student7, student8, student9,
				student10, student11 };

		for (Student st : getStudentLearnAgain(students)) {
			System.out.println(st.toString());
		}

	}

	public static Student[] getStudentTypeA(Student[] st) {
		Student[] students = new Student[st.length];
		int count = 0;
		for (Student student : st) {
			if (student.getClassification().equals(Classification.A)) {
				students[count++] = student;
			}
		}
		return students;
	}

	public static Student[] getStudentLearnAgain(Student[] st) {
		Student[] students = new Student[st.length];
		Student[] studentsresult = new Student[st.length];
		int count = 0;
		int countresult = 0;
		for (Student student : st) {
			for (int i = 0; i < students.length; i++) {
				if(students[i] != null) {
					if (student.getId() == students[i].getId()) {
						studentsresult[countresult++] = student;
						break;
					}
				}
			}
			students[count++] = student;
		}
		return studentsresult;
	}
}

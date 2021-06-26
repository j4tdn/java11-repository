package bt01;

public class Bt01 {
	public static void main(String[] args) {
		Student[] student = student();
		System.out.println("C1: student A point");
		getRank(student);
		System.out.println("C2: student learn again");
		getLearnAgain(student);
	}

	private static void getLearnAgain(Student[] student) {
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			count = 0;
			for (int j = 1; j < student.length; j++) {
				if (student[i].getId() == student[j].getId()) {
					count++;
				}
			}
			if (count >= 2) {
				System.out.println(student[i]);
			}
		}
	}

	private static void getRank(Student[] students) {
		for (Student student : students) {
			if (student.getRank() == Rank.A) {
				System.out.println(student);
			}
		}
	}

	private static Student[] student() {
		Student s1 = new Student(102, "Nam", Rank.C);
		Student s2 = new Student(104, "Hoàng", Rank.D);
		Student s3 = new Student(109, "Lan", Rank.A);
		Student s4 = new Student(103, "Bảo", Rank.F);
		Student s5 = new Student(105, "Nguyên", Rank.B);
		Student s6 = new Student(107, "Vũ", Rank.F);
		Student s7 = new Student(103, "Bảo", Rank.F);
		Student s8 = new Student(202, "Đạt", Rank.C);
		Student s9 = new Student(107, "Vũ", Rank.C);
		Student s10 = new Student(193, "Bảo", Rank.B);
		Student s11 = new Student(104, "Hoàng", Rank.B);

		return new Student[] { s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11 };
	}
}

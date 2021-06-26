package ex01;

public class App {
	public static void main(String[] args) {
		Student[] students = {new Student(102, "Nam", Classification.C),
							  new Student(104, "Hoàng", Classification.D),
							  new Student(109, "Lan", Classification.A),
							  new Student(103, "Bảo", Classification.F),
							  new Student(105, "Nguyên", Classification.B),
							  new Student(107, "Vũ", Classification.F),
							  new Student(103, "Bảo", Classification.F),
							  new Student(202, "Đạt", Classification.C),
							  new Student(107, "Vũ", Classification.C),
							  new Student(193, "Bảo", Classification.B),
							  new Student(104, "Hoàng", Classification.B),
		};
		gradeA(students);
//		learnAgain(students);
	}

	private static void gradeA(Student[] std) {
		for (Student student : std) {
			if (student.getClassification() == Classification.A) {
				System.out.println(student);
			}
		}
	}

//	private static Student[] learnAgain(Student[] std) {
//		int count = 0;
//		for(Student student : std) {
//			for(Student student2 : std) {
//				if(student.getId() == student2.getId()) {
//					count ++;
//				}
//				if(count == 2) {
//					System.out.println(student);
//				}
//			}
//		}
//	}
}

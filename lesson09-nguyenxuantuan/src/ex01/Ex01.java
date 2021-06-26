package ex01;

import ex01.Student;
import ex01.Rank;

public class Ex01 {
	public static void main(String[] args) {
		Student[] students = {
				
				new Student("102", "Nam", Rank.C),
				new Student("104", "Hoàng", Rank.D),
				new Student("109", "Lan", Rank.A),
				new Student("103", "Bảo", Rank.F),
				new Student("105", "Nguyên", Rank.B),
				new Student("107", "Vũ", Rank.F),
				new Student("103", "Bảo", Rank.F),
				new Student("202", "Đạt", Rank.C),
				new Student("107", "Vũ", Rank.C),
				new Student("193", "Bảo", Rank.B),
				new Student("104", "Hoàng", Rank.B)
			};
		System.out.println("Những học sinh đoạt loại A trong năm 2021 là:");
		studentsGetA(students);
		
		
		System.out.println("Những học sinh tham gia học lại môn cấu trúc dữ liệu trong năm 2021 là:");
        studentsLearnAgain(students);
		
	}
	private static void studentsGetA(Student[] students) {
		for(Student student : students) {
			if(student.getRank() == Rank.A) {
				System.out.println(student);
			}
		}
	}

	private static void studentsLearnAgain(Student[] students) {
		int index = 0;

		for (int i = 0; i < students.length; i++) {
			if (students[i].getRank() == Rank.F) {
			    for (int j = i + 1; j < students.length; j++) {
					if (students[i].getId().equals(students[j].getId())) {
						int k = 0;
						for (k = 0; k < index; k++) {
							if (students[k].getId().equals(students[i].getId())) {
								break;
							}
						}
						if (k == index) {
							System.out.println(students[i]);
						}
					}
				}
			}
		}
	}
	
}

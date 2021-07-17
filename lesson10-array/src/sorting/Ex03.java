package sorting;

import bean.Student;
import utils.ArrayUtils;

public class Ex03 {
	public static void main(String[] args) {
		Student[] st = getStudent();
		
		// bubble sort
		for(int i = 0; i < st.length; i++) {
			for(int j = 0; j < st.length - i - 1; j++) {
				if(st[j].getSchoolI() > st[j + 1].getSchoolI()) {
					swap(st, j, j + 1);
					continue;
				}
				if(st[j].getSchoolI() == st[j+1].getSchoolI()) {
					if(st[j].getStudentId() > st[j+1].getStudentId()) {
						swap(st, j, j + 1);
					}
				}
			}
		}
		 
		ArrayUtils.printf(st);
	}
	
	private static Student[] getStudent() {
		return new Student[] {
				new Student(1, 12, "a", 27),
				new Student(2, 27, "B", 12),
				new Student(3, 12, "c", 27),
				new Student(2, 29, "D", 25),
				new Student(1, 18, "f", 27),
				new Student(1, 10, "K", 19),
				new Student(4, 12, "B", 27),
		};
	}
	
	private static void swap(Student[] st, int i, int j) {
		Student tmp = st[i];
		st[i] = st[j];
		st[j] = tmp;
		
	}
}

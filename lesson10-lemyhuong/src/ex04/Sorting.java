package ex04;

import utils.ArrayUtils;
import utils.Swap;

public class Sorting {
	public static void main(String[] args) {
		Student[] students = getStudent();
		
		//bubble sort 
		bubbleSortAcs(students);
		ArrayUtils.printf(students);
	
	}
	
	private static Student[] getStudent() {
		return new Student[] {
				new Student(1, "Eva", 19),
				new Student(3, "Mary", 23),
				new Student(4, "Adam", 18),
				new Student(6, "Mary", 20)
		};
	}
	
	private static Student[] bubbleSortAcs(Student[] students) {
		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < students.length - i - 1; j++) {
				if (students[j].getName().compareTo(students[j+1].getName()) > 0) {
					Swap.swap(students, j, j + 1);
				}
				
				if (students[j].getName().compareTo(students[j+1].getName()) == 0) {
					if (students[j].getAge() < students[j+1].getAge()) {
						Swap.swap(students, j, j + 1);
					}
				}
			}
		}
		
		return students;
	}
	
}

package objectsort;

import bean.ArrayUtils;

public class ObjectSort {
	public static void main(String[] args) {

		Student[] students = getStudents();
		ArrayUtils.printf(objectSort(students));
		System.out.println("====================");
		
	}
	
	private static void swap(Student[] student, int i, int j) {
		Student tmp = student[i];
		student[i] = student[j];
		student[j] = tmp;
	}
	
	//Object sort
		private static Student[] objectSort(Student[] students) {
			for (int i = 0; i < students.length; i++) {
				for (int j = 0; j < students.length-i-1; j++) {
					if(students[j].getAge() > students[j+1].getAge()) {
						swap(students, j, j+1);
					}
				}
			}
			return students;
			
		}
//		private static Student[] nameSort(Student[] students) {
//			for (int i = 0; i < students.length; i++) {
//				for (int j = 0; j < students.length-1-i; j++) {
//					if(students[i].getName().compareTo(students[j+1].getName()) >0) {
//						swap(students, j, j+1);
//					} 
//				}
//			}
//			return students;
//		}
		
	private static Student[] getStudents() {
			return new Student[] {
					new Student(1,"Teo", 18),
					new Student(4,"Anh", 12),
					new Student(2,"Cong", 11),
					new Student(5,"Tuan", 20),
					new Student(3,"Jack", 31),
					new Student(6,"Lee", 24),
			};
		}
}
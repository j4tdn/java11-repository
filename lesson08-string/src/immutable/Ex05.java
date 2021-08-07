package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		// student.txt
		// 1. Join, 094 329 2323, Male, English-Math
		// 2. July, 034 098 2323, Female, Biology-Chemistry
		
		// class: Student >> name, phone, gender, hobbies
		
		String line = "Join, 094 329 2323, Male, English-Math";
		Student student = transfomer(line);
		System.out.println(student);
	}
	
	private static Student transfomer(String line) {
		Student student = null;
		String[] elements = line.split(",");
		System.out.println("============");
		if (elements.length == 4) {
			student = new Student(elements[0], elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]);
		}
		return student;
	}
}

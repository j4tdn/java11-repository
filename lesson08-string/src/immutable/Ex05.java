package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		// student.txt
		// 1. Join, 094 235 1423, Male, English-Math
		// 2. Rose, 093 215 1323, Female, Biology-Chemistry

		// class: Student >> name, phone, gender, hobbies

		String line = "Join, 094 235 1423, Male, English-Math";
		Student student = transfom(line);
		System.out.println(student);
	}

	private static Student transfom(String line) {
		Student student = null;
		String[] elements = line.split(",\\s");
		if (elements.length == 4) {
			student = new Student(elements[0], elements[1], "male".equalsIgnoreCase(elements[2]), elements[1]);
		}
		return student;
	}
}

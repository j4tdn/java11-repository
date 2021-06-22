package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		// txt
		// 1. Join, 012 353 4234, Male, English-Math
		// 2. Kate, 035 534 6452, Female, Biology-Chemistry

		// class: Student >> name, phone, gender, hobbies

		String line = "Join, 012 353 4234, Male, English-Math";
		Student student = transformer(line);
		System.out.println(student);
	}

	private static Student transformer(String line) {
		Student student = new Student();
		String[] elements = line.split(",\\s");
		if (elements.length == 4) {
			student = new Student(elements[0], elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]);
		}
		return student;
	}
}

package immutable;

import beans.Student;

public class Ex05 {
	public static void main(String[] args) {
		// txt
		// 1. Join, 094 329 2365, Male, English-Math
		// 2. Kate, 034 329 9567, Female, Biology-Chemistry
		String line = "Join, 094 329 2365, Male, English-Math";
		Student student = transformer(line);
		System.out.println(student);
	}

	private static Student transformer(String line) {
		Student student = null;
		String[] elements = line.split(",\\s");
		if(elements.length == 4) {
			student = new Student(elements[0],elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]);
		}
		return student;
	}
}

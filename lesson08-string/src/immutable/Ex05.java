package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		String line = "john, 123 456 789, male, english-math";
		Student student = transformer(line);
		
	}
	
	private static Student transformer(String line) {
		Student student = new Student();
		String[] elements = line.split(", ");
		if (elements.length == 4) {
			student = new Student(elements[0], elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]);
		}
		return student;
	}
}

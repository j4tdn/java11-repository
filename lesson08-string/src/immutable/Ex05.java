package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		// txt
		// 1. Join, 094 329 2365, Male, English-Math
		// 2. Kate, 034 898 2514, Female, Biology-Chemistry
		
		//class: Student >> name, phone, gender, hobbies
		
		String line = "Join, 094 329 2365, Male, English-Math";
		transformer(line);
	}
	private static Student transformer(String line) {
		Student student = new Student();
		String[] elements = line.split(", ");
		if(elements)
			student.setName(elements[0]);
			
		
		return student;
	}
}
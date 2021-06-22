package immutable;

import bean.Students;

public class Ex05 {
	public static void main(String[] args) {
		// txt
		// 1. Join, 094 329 2365, Male, English-Math
		// 2. Kate, 034 898 2514, Female, Biology-Chemistry
		
		//class: Student >> name, phone, gender, hobbies
		
		String line = "Join, 094 329 2365, Male, English-Math";
	
		Students student = transformer(line);
		System.out.println(student);
	}
	private static Students transformer(String line) {
		Students student = new Students();
		String[] elements = line.split(", ");
		if(elements.length == 4)
			student = new Students(elements[0], elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]);	
		return student;
	}
}

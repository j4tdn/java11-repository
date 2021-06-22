package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		String line = "John, 094 323 3232, Male, English-Math";
		Student student = transformer(line);
		System.out.println(student);
		
	}
	private static Student transformer(String line) {
		Student student = new Student();
		String[] elements = line.split(",\\s");
		if(elements.length == 4) {
			student = new Student(elements[0], elements[1], 
					              "male".equalsIgnoreCase(elements[2]), elements[3]);
			
		}
		return student;
	}

	
}

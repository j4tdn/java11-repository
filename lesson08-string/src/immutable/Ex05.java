package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		String line = "john, 097 971 5441, male, English-Math";
		Student student = transformer(line);
		System.out.println(student);
	}
	
	private static Student transformer(String line) {
		Student student = new Student();
		String[] elements = line.split(",\\s");
		
		if (elements.length == 4) {
			student = new Student(elements[0], elements[1],
					"male".equalsIgnoreCase(elements[2]),
					 elements[3]);
			
//			student.setName(elements[0]);
//			student.setPhone(elements[1]);
//			student.setGender("male".equalsIgnoreCase(elements[2]));
//			student.setHobbies(elem	ents[3]);
		}
		
		return student;
	}
}
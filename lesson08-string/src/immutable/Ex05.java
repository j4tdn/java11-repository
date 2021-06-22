package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		//txt
		//1. John, 0965 865 242, Male, English-Math
		//2. Kate, 0935 452 575, Female, Biology- Chemistry
		
		//class: Student >> name, phone, gender, hobbies
		
		String line = "John, 0965 865 242, Male, English-Math";
		Student student	= transformer(line);
		System.out.println(student);
		
		
	}
	
	private static Student transformer(String line) {
		Student student = null;
<<<<<<< HEAD
		String[] elements = line.split(",");
		if(elements.length == 4) {
=======
		String[] elements = line.split(",\\s");
		if(elements.length == 4) {	
>>>>>>> e260eec (lesson08-string 22.06.2021)
			 student = new Student(elements[0], elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]); 
		}
		return student;
	}
}

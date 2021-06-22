package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {

		String line = "Join, 094 329 2365, Male, English-Math";
		Student student = tranformer(line);
		System.out.println(student);
	}

	private static Student tranformer(String line) {
		Student student = null;
		String[] elements = line.split(",\\s");
		if(elements.length == 4) {
			student = new Student(elements[0],
					elements[1], 
					"male".equalsIgnoreCase(elements[2]),
					elements[3]);
	
		}
		return student;
	}
}

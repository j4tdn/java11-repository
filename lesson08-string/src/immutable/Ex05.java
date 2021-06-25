package immutable;

import bean.Student;

public class Ex05 {
    public static void main(String[] args) {
		// Student.txt
    	// 1. Join,094 329 2365, Male, English-Math
    	// 2. Kate, 034 989 2514, Female, Biology-Chemistry
    	
    	// class: Student >> name, phone, gender, hobbies
    	
    	String line = "Join,094 329 2365, Male, English-Math";
    	Student student = transfomer(students);
    	
	}
    
    private static Student transfomer(Student student) {
    	Student student = null;
    	String[] elements = student.split(",");
    	if(elements.length == 4){
    		student = new Student(elements[0],elements[1], "male".equalsIgnoreCase(elements[2]), elements[3]);
    	}
    	return student;
    }
}

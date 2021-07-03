package declaration;

import bean.Student;

public class Ex01 {
	public static void main(String[] args) {
		// {0, 0, 0, 0}
		int[] digits = new int[4];
		System.out.println("length: " + digits.length);
		System.out.println("digit i: " + digits[2]);

		int[] numbers = { 5, 3, 2 };
		System.out.println("numbers length: " + numbers.length);
		System.out.println("number digit i: " + numbers[2]);
		
		System.out.println("numbers's class: " + numbers.getClass());
		
		// for-index
		for(int i = 0; i < numbers.length; i++) {
			System.out.println("index " + i + ": " + numbers[i]);
		}
		
		// loop end to start
		for(int i = numbers.length - 1; i >= 0; i--) {
			System.out.println("index " + i + ": " + numbers[i]);
		}
		
		// for-each
		int k = 0;
		for(int number: numbers) {
			System.out.print(k + ": ");
			System.out.println(number);
			k++;
		}
		
		System.out.println();
		
		String[] sequences = new String[10];
		System.out.println("sequences i: " + sequences[0]);
		
		System.out.println("sequences's class: " + sequences.getClass());
		
		String[] names = {"a", "b", "c"};
		System.out.println("name[1] " + names[1]);
		
		System.out.println();
		
		Student[] students = new Student[3];
		
		System.out.println("name class: " + students.getClass());
		
		// students[0].setId(123); // NPE
		System.out.println("student[0]: " + students[0]);

		Student[] preStudents = { new Student(123, "Heo", 23), new Student(443, "Teo", 24) };
		System.out.println("preStudent[1] => " + preStudents[1]);
		System.out.println("student[0] name: " + preStudents[0].getName());
		System.out.println("student[1] age: " + preStudents[1].getAge());
		
	}
}

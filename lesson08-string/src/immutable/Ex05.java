package immutable;

import bean.Student;

public class Ex05 {
	public static void main(String[] args) {
		// File: Student.txt
		// 120130, Adam Ton, 7.9
		// 125635, Kate Hence, 8.2
		String[] lines = {"120130, Adam Ton, 7.9", "125635, Kate Hence, 8.2"};
		
		// Java Objects
		for (String line: lines) {
			String[] tokens = line.split(", ");
			Student student = new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
			System.out.println(student);
		}
		
		// Find valid numbers in the text below
		String text = "ab123d87e012f";
		// d stands for digit
		// D = not d
		String[] numbers = text.split("\\D+");
		for (String number: numbers) {
			if (!number.isEmpty())
				System.out.println(number);
		}
	}
}

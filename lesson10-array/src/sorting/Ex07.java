package sorting;

import java.util.Arrays;
import java.util.Comparator;

import bean.Student;
import utils.ArrayUtils;

public class Ex07 {
	public static void main(String[] args) {
		Student[] students = getStudent();

		Arrays.sort(students, Comparator.comparing(i -> i.getSchoolI()));

		ArrayUtils.printf(students);

	}

	private static Student[] getStudent() {
		return new Student[] { new Student(1, 12, "a", 27), new Student(2, 27, "B", 12), new Student(3, 12, "c", 27),
				new Student(2, 29, "D", 25), new Student(1, 18, "f", 27), new Student(1, 10, "K", 19),
				new Student(4, 12, "B", 27), };
	}
}

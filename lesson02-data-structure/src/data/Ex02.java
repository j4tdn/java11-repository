package data;

public class Ex02 {
	
	// Alt + left button: back to last point mouse
	static int year = 2021;
	
	public static void main(String[] args) {
		int age = 20;
		int salary = 20;
		age = 21;
		salary = 22;
		age = salary;
		System.out.println("age: " + age);
		System.out.println("salary: " + salary);
		increase(salary);
		System.out.println("i salary: " + salary);
	}

	private static void increase(int input) {
		input = 30;
		System.out.println("Year swap" + year);
	}
}

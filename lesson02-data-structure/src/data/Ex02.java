package data;

public class Ex02 {
	// global variable: atrribute
	static int year = 2021;

	// function: method
	public static void main(String[] args) {
		
		int year = 1998;
		System.out.println("year: " + year);
		
		int age = 20;
		int salary = 20;

		age = 21;
		salary = 22;

		age = salary;// assign salary value to age

		System.out.println("age " + age);
		System.out.println("salary " + salary);

		salary = 30;
		swap(salary, age);
		System.out.println("swap salary: " + salary);
		System.out.println("swap age: " + age);

	}

	private static void increase(int input) {
		// calculation
		input = 30;

	}

	private static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		
		//alt left || right: chuyen toi cho dang tro chuot truoc sau
		System.out.println("Year swap: " + Ex02.year);
	}
}

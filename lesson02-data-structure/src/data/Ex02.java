package data;

public class Ex02 {
	
	static int year = 2021;
	
	public static void main(String[] args) {
		
		int year = 1999;
		System.out.println("year: " + year);
		
		int age = 20;    //
		int salary = 20; //
		age = 21;
		salary = 22;
		age = salary;
		System.out.println("age: " + age);
		System.out.println("salary: " + salary);
		
		increase(salary);
		System.out.println("i salary: " + salary);
		
		salary = 30;
		swap(salary, age);
		
		System.out.println("swap salary: " + salary);
		System.out.println("swap age: " + age);
	}
	
	private static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		System.out.println("swap year: " + year);
	}
	
	private static void increase(int input) {
		input = 30;
	}

}

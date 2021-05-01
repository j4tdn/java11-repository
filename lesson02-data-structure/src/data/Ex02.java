package data;

public class Ex02 {
	
	// global variable: attribute
	static int year = 2021;
	
	// function: method
	public static void main(String[] args) {
		
		int year = 1998;
		System.out.println("year: " + year);
		
		// local variable
		int age = 20;   
		int salary = 20;
		age = 21;  
		salary = 22;
		
		// assign salary value to age
		age = salary; 
		
		System.out.println("age: " + age);
		System.out.println("salary: " + salary);
		
		increase(salary);
		System.out.println("i salary: " + salary);
		
		salary = 30;
		swap(salary, age); // salary=30, age=22
		
		System.out.println("swap salary: " + salary); // sal=22
		System.out.println("swap age:    " + age); // age=30
	}
	
	// a = 5, b = 7
	private static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		
		// alt left || right: shift to previous|next cursor
		System.out.println("Year swap: " + year);
	}
	
	private static void increase(int input) {
		// calculation
		input = 30;
	}
}

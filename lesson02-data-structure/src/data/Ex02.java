package data;

public class Ex02 {
	public static void main(String[] args) {
		int age = 20;
		int salary = 20;
		
		age = 21;
		salary = 22;
		age = salary ; // gan salary cho age		
		System.out.println("age: " + age);
		System.out.println("Salary: " + salary);	
		
		increase(salary);
		System.out.println("i salary: " + salary);
		salary = 30;
		swap(salary, age);
		
		System.out.println("swap salary: " + salary);
		System.out.println("swap age: " + age);
	}
	private static void swap(int a , int b) {
		int tmp = a;
		a = b;
		b = tmp;
		
	}
	
	private static void increase(int input) {
		//calculation
		input = 30;
	}

}


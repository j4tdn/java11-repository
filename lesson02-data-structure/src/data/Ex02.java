package data;

public class Ex02 {
	
//	global variable: attribute
	static int year = 2021;
	
//	function: method
	public static void main(String[] args) {
		
		int year = 1998;
		System.out.println("year: "+ year);
		
		int age = 20;
		int salary = 20;
		age = 21;
		salary = 22;

		age = salary; // assign salary value to age

		System.out.println("age: " + age);
		System.out.println("salary: " + salary);

		increase(salary);
		System.out.println("i salary: " + salary);
		
		salary = 30;
		swap(salary, age); //salary = 30, age = 22
		
		System.out.println("swap salary: "+ salary);
		System.out.println("swap age: "+ age);
	}
	
//	a = 5, b = 7.
//	nhung swap chi trong ham nay thoi, bien salary, age khac voi bien a, b => salary and age still old value
	private static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		
//		alt + right: shift to previous cursor
		System.out.println("year swap: " + year);
	}

	private static void increase(int input) {
//		calculation
		input = 30;
	}

}

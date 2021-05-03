package data;

public class Ex02 {
<<<<<<< HEAD
	//global variable = attribute
	static int year = 2021;
	//function = method
	public static void main(String[] args) {
		int year = 1998;
		System.out.println("year: " + year);
		
		int age = 20;
		int salary = 20;
		age = 21; 
		salary = 22;
		age = salary; //assign salary value to age
=======
	
	static int year = 2021;
	
	public static void main(String[] args) {
		
		int year = 1999;
		System.out.println("year: " + year);
		
		int age = 20;    //
		int salary = 20; //
		age = 21;
		salary = 22;
		age = salary;
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
		System.out.println("age: " + age);
		System.out.println("salary: " + salary);
		
		increase(salary);
		System.out.println("i salary: " + salary);
		
		salary = 30;
		swap(salary, age);
<<<<<<< HEAD
		System.out.println("swap salary: " + salary); //salary = 30
		System.out.println("swap age: " + age); //age = 22
		
	}
	private static void swap (int a, int b) {
		int tmp = a;
		a = b;
		b = a;
		
		System.out.println("year swap: " + year);
	}
	
	private static void increase(int input) {
		//calculation
		input = 30;
	}
}
// alt + left,right: shift to previous,next cursor
=======
		
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
>>>>>>> ba78b3a (lesson02-03 02.05.2021)

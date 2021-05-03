package data;

public class Ex02 {
	
	//global variable: java calls it as an attribute
	static int year = 2021;
	
	//function: method
	public static void main(String[] args) {
		
		int year = 1998;
		System.out.println("year: " + year);
		
		//local variable : java calls it as an attribute
		int age = 20;
		int salary = 20;
		age = 21;
		salary = 22;

		age = salary; // assign value of salary to age. salary = 22 so age will = 22

		System.out.println("age: " + age);
		System.out.println("salary: " + salary);

		increase(salary);
		System.out.println("i salary: " + salary);

		salary = 30;
		//swap hoan doi
		//salary = 30, age = 22
		swap(salary, age); // truyen bien
		
		System.out.println("swap salary: " + salary);
		System.out.println("swap age: " + age);
	}
	
	//a = 5, b = 7
	//assign value of salary to a
	//assign value of age to b
	private static void swap(int a, int b) { //swap a and b, NOT swap salary and age
		int tmp = a; //tmp = 5, a = 5
		a = b; // assign value of b = 7 to a so a = 7
		b = tmp; //assign value of tmp = 5 to b so b = 5
		
		//alt left or right to shift to previous or next cursor
		System.out.println("Year swap: " + Ex02.year); // to call global variable 'year' it should be static
	}

	// salary here is different from above, salary can be any word (eg: input, etc)
	private static void increase(int salary) { // assign value of salary above to this salary
		// calculation
		salary = 30;
	}

}

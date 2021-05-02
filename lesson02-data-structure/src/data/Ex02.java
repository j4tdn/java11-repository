package data;

public class Ex02 {
	// global variable: attribute
	static int year = 2021;

	// funtion: method
	public static void main(String[] args) {
		int age = 20;
		int salary = 20;
		age = 21;
		salary = 22;
		age = salary;// assign salary value to age

		System.out.println("age: " + age);
		System.out.println("salary: " + salary);
		salary = 30;
		swap(age, salary);
		System.out.println("SwapAge: " + age);
		System.out.println("SwapSalary: " + salary);
	
	}
    
	private static void swap(int a, int b) {
		int tmp = a;
		a = b;
		b = tmp;
		//alt left || right: shift to previous|next cursor
		System.out.println("Year swap: " + year);
	}
}

package data;

public class Ex02 { 
	static int year = 2021;// global variable: attribute; 
	// funtion: method;
	
	public static void main(String[] args) {
		int year = 1998;
		System.out.println("year: " + year);
		int age = 20;
		int salary = 20;
		age = 21;
		salary = 22;
		age = salary;//assign salary value to age
		System.out.println("age: " + age);
		System.out.println("salary: " + salary);
		
		increase(salary);
		System.out.println("i salary: " + salary);
		
		salary = 30;
		swap(salary, age);// sal =30, age =22
		System.out.println("swap salary: " + salary);//sal =30
		System.out.println("swap age: " + age);// age =22
	}
	private static void swap(int a, int b) {
		int tmp = a;
		b = a;
		a = tmp;
		//alt left||right: shift to previous| next cursor
		System.out.println("Year swap: " + year);
	}
	private static void increase(int input) {
    	input = 30;
    }
}

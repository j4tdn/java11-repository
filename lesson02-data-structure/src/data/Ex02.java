package data;

public class Ex02 {
	// 
	 static int year = 2021;
	
	public static void main(String[] args) {
		int year = 1998;
		System.out.println("year : " + year); //1998
		
		
		int age = 20;  // 
		int salary = 20; // 
		
		age = 21;
		salary = 22;
		age = salary;
		System.out.println("age : " + age);
		System.out.println("salary : " + salary);
		
		increase(salary);
		System.out.println("sal : "+ salary);
		
		salary = 30;
		swap(salary, age); // sal = 30 , age = 22;
		System.out.println("sal : "+ salary); // sal = 30
		System.out.println("age : "+ age); // age = 22
		
	}
	
	private static void swap(int a, int b) {
		int temp = a;
			a = b;
			b = temp;
			
			System.out.println("Year swap : " + year );
	}
	
	
	private static void increase(int input) {
		// calculation
		input = 30;
	}

}

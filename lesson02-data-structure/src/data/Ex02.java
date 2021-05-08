package data;

public class Ex02 {

	// global variable: atribute
	static int year = 2021; //vì biến ngang hàng với hàm, muốn gọi biến thì phải dùng static để class.tên biến

	// funtion: method
	public static void main(String[] args) {

		int year = 1998;
		System.out.println("year: " + year);

		// local variable => k cần khai báo access modifier vì nó chỉ hoạt động trong
		int age = 20;
		int salary = 20;
		age = 21;
		salary = 22;
		age = salary; // assign salary value to

		System.out.println("age: " + age);
		System.out.println("salary: " + salary);

		increase(salary);
		System.out.println("i salary: " + salary);

		salary = 30;
		swap(salary, age);
		System.out.println("swap salary: " + salary);
		System.out.println("swap age: " + age);
	}
	// a=5;b=7;

	private static void swap(int a, int b) {
		int tmp = a;
		b = tmp;
		a = b;
		
		//alt left||right: shift to privious next cursor
		System.out.println("Year swap: "+year);

	}

	private static void increase(int input) {
		// caculation
		input = 30;
	}
}

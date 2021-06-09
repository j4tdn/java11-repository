package data;

public class Ex02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          int age =20;
          int salary = 20;
          
          age = 22;
          salary = 21;
          age = salary;
          System.out.println("Age: "+age);
          System.out.println("Salary: "+salary);
	}
	private static void increase(int salary) {
		salary = 30;
	}

}

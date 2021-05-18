package exercises;

import entities.President;
import entities.Staff;
import entities.Manager;
import entities.People;

public class Ex04_HRM {
	public static void main(String[] args) {
		People p1 = new President("Nguyen Van A", 1990, 3.5f, 3f);
		People p2 = new Manager("Nguyen Van B", 1994, 2.3f, 10);
		People p3 = new Staff("Nguyen Van C", 2000, 1.5f, "design");
		
		
		System.out.printf("%-20s %-20s %-20s %20s\n", "Position", "Coe job" , "Coe salary", "Salary" );
		System.out.println("=====================================================================================");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
	}

}

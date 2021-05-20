package hw4;

public class Demo {
	public static void main(String[] args) {
		People d1 = new Director("Nguyen Giam Doc", 1980, 1.5, 1);
		People h1 = new HeadOfDepartment("Phan Quan Ly", 1995, 3.2, 12);
		People e1 = new Employee("Tran Nhan Vien", 1997, 2.8, "Maketing Department");
		
		System.out.printf("\n%-20s%-15s%20s%25s\n", "Name", "Birth Year", "Position", "Salary");
		System.out.println("===========================================================================================");
		System.out.println(d1);
		System.out.println(h1);
		System.out.println(e1);
	}
}

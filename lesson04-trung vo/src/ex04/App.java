package ex04;

public class App {
	public static void main(String[] args) {
		Director d1 = new Director("nguyen van A", 1997, 2f, 3f);
		Manager m1 = new Manager("Tran thi B", 1997, 1.5f ,2);
		Employee e1 = new Employee("Tran van C", 2003, 1.2f, "Accountment");
		Employee e2 = new Employee("Ho thi D", 2004, 1.2f, "Humanresource");
		
		
		System.out.printf("\n%-15s %-20s %10s %15s %15s %15s\n", "Chuc vu", "Ho ten", "Nam sinh", "He so luong", "He so Chuc vu", "Luong","nhan vien quan li","Bo phan");
		System.out.println("=====================================");
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Giam doc", d1.getName(),d1.getYearOfBirth(),d1.getCoEffiencts(),d1.getCoRespon(),d1.getSalary());
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Quan li", m1.getName(),m1.getYearOfBirth(),m1.getCoEffiencts(),m1.getSalary(), m1.getNumberOfStaff());
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Nhan vien", e1.getName(),e1.getYearOfBirth(),e1.getCoEffiencts(),e1.getSalary(),e1.getDepartmentName());
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Nhan vien", e2.getName(),e2.getYearOfBirth(),e2.getCoEffiencts(),e2.getSalary(),e2.getDepartmentName());

	}
	
}

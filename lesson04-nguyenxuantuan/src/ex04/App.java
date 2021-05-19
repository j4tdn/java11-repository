package ex04;

import ex04.Director;
import ex04.Employee;
import ex04.Manager;

public class App {
	public static void main(String[] args) {
		Director giamdoc = new Director("Nguyen Xuan Tuan", "1989", 2.5f, 1.5f);
		Manager truongphong = new Manager("Le Thien Nhan", "1993", 1.8f, 10);
		Employee nhanvien1 = new Employee("Tran Bao Ngoc", "1996", 1.2f, "Ke Toan");
		Employee nhanvien2 = new Employee("Dao Duy Nghia", "2000", 1.5f, "Nhan Su");
		
		System.out.printf("\n%-15s %-20s %10s %15s %15s\n", "Chuc vu", "Ho ten", "Nam sinh", "He so luong", "Luong");
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Giam doc", giamdoc.getName(), giamdoc.getYearOfBirth()
														,giamdoc.getCoefficientSalary(), giamdoc.getSalary());
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Truong phong", truongphong.getName(), truongphong.getYearOfBirth()
				                                        ,truongphong.getCoefficientSalary(), truongphong.getSalary());
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Nhan Vien", nhanvien1.getName(), nhanvien1.getYearOfBirth()
														,nhanvien1.getCoefficientSalary(), nhanvien1.getSalary());
		System.out.printf("%-15s %-20s %10s %15s %15s\n", "Nhan vien", nhanvien2.getName(), nhanvien2.getYearOfBirth()
														,nhanvien2.getCoefficientSalary(), nhanvien2.getSalary());
			
		
	}
}
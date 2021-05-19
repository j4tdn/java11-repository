package Ex04;

import java.util.Scanner;

public class PersonUtils {
	private static Scanner scanner = new Scanner(System.in);

	private PersonUtils() {

	}

	public static void inputInfo(Person person) {
		System.out.println("\nNhap thong tin " + person.getClass().getSimpleName());
		System.out.print("Nhap ten: ");
		person.setFullName(scanner.nextLine());
		System.out.print("Nhap nam sinh: ");
		person.setYearOfBirth(scanner.nextInt());
		System.out.print("Nhap he so luong: ");
		person.setCoefficientSalary(scanner.nextFloat());
	}

	public static void inputDirector(Director director) {
		inputInfo(director);
		System.out.print("Nhap he so chuc vu: ");
		director.setCoefficientJob(scanner.nextFloat());
		scanner.nextLine();
	}

	public static void inputManager(Manager manager) {
		inputInfo(manager);
		System.out.print("Nhap so luong nhan vien: ");
		manager.setQuantityEmployee(scanner.nextInt());
		scanner.nextLine();
	}

	public static void inputEmployee(Employee employee) {
		inputInfo(employee);
		System.out.print("Nhap ten don vi: ");
		scanner.nextLine(); // ignore the new line character
		employee.setDepartmentName(scanner.nextLine());
	}
}

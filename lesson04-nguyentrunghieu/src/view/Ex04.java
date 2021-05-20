package view;

import java.util.Scanner;

import bean.Director;
import bean.Manager;
import bean.Person;
import bean.Staff;

public class Ex04 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Person[] people = { new Director(), new Manager(), new Staff(), new Staff() };
		input(people);
		output(people);
	}

	private static void output(Person[] people) {
		for (Person person : people) {
			System.out.println(person);
		}
	}

	private static void input(Person[] people) {
		for (Person person : people) {
			if (person instanceof Director) {
				inputDirector((Director) person);
			} else if (person instanceof Manager) {
				inputManager((Manager) person);
			} else {
				inputStaff((Staff) person);
			}
		}
	}

	public static void inputInfo(Person person) {
		System.out.println("\nNhap thong tin " + person.getClass().getSimpleName());
		System.out.print("Nhap ten: ");
		person.setName(sc.nextLine());
		System.out.print("Nhap nam sinh: ");
		person.setBirthYear(sc.nextLine());
		System.out.print("Nhap he so luong: ");
		person.setSalaryCoeff(Float.parseFloat(sc.nextLine()));
	}

	public static void inputDirector(Director director) {
		inputInfo(director);
		System.out.print("Nhap he so chuc vu: ");
		director.setCoefficientJob(Float.parseFloat(sc.nextLine()));

	}

	public static void inputManager(Manager manager) {
		inputInfo(manager);
		System.out.print("Nhap so luong nhan vien: ");
		manager.setQuantityEmployee(Integer.parseInt(sc.nextLine()));
	}

	public static void inputStaff(Staff staff) {
		inputInfo(staff);
		System.out.print("Nhap ten don vi: ");
		staff.setDepartmentName(sc.nextLine());
	}
}

package ex04;

import java.util.Scanner;

public class PeopleUtils {

	private PeopleUtils() {

	}

	public static void inputPeople(People people) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap id : ");
		people.setId(ip.nextInt());
		ip.nextLine();
		System.out.print("Nhap ho ten : ");
		people.setName(ip.nextLine());
		System.out.print("Nhap he so luong : ");
		people.setHsl(ip.nextFloat());
		System.out.print("Nhap he so chuc vu : ");
		people.setHscv(ip.nextFloat());
	}
}

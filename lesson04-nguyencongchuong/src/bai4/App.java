package bai4;

import java.util.Scanner;

import bai4.PeopleFactory.PeopleType;

public class App {
	public static void main(String[] args) {
		People p1 = PeopleFactory.getPeople(PeopleType.GIAMDOC);
		p1.input();
		People p2 = PeopleFactory.getPeople(PeopleType.TRUONGPHONG);
		p2.input();
		People p3 = PeopleFactory.getPeople(PeopleType.NHANVIEN);
		p3.input();
		People p4 = PeopleFactory.getPeople(PeopleType.NHANVIEN);
		p4.input();

		System.out.println("Giám đốc     " + p1 + ", Lương: " + p1.Luong());
		System.out.println("Trưởng phòng " + p2 + ", Lương: " + p2.Luong());
		System.out.println("Nhân viên    " + p3 + ", Lương: " + p3.Luong());
		System.out.println("Nhân viên    " + p4 + ", Lương: " + p4.Luong());
	}

}

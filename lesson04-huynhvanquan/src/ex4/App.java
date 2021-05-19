package ex4;

import java.util.ArrayList;
import java.util.Scanner;
import ex4.PeopleFactory.PosType;

public class App {
	public static void main(String[] args) {
		Director d = new Director();
		HeadOfDepartment h = new HeadOfDepartment();
		Staff s1 = new Staff();
		Staff s2 = new Staff();

		d.input();
		h.input();
		s1.input();
		s2.input();

		System.out.println(d.toString(1));
		System.out.println(h.toString(1));
		System.out.println(s1.toString(1));
		System.out.println(s2.toString(1));

		System.out.println("=====");
		System.out.println(String.format("%-10s %28s", "Position", "Salary"));
		System.out.println("---------------------------------------");
		System.out.println(d.toString(2));
		System.out.println(h.toString(2));
		System.out.println(s1.toString(2));

	}

}

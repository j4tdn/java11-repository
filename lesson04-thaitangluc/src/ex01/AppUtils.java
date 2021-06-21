package ex01;

import java.util.Scanner;

public class AppUtils {
	
	public static Student insert() {
		
		Scanner ip = new Scanner(System.in);
		int id = ip.nextInt();
		ip.nextLine();
		String name = ip.nextLine();
		float theoryPoint = ip.nextFloat();
		float practicePoint = ip.nextFloat();
		Student sv = new Student(id, name, theoryPoint, practicePoint);
		return sv;
	}
	
	public static void print(Student[] svs) {
		System.out.printf("%-10s%-15s%-10s%-10s%-10s\n","MSSV","Ho ten","Diem LT", "Diem TH", "Diem TH");
		for(Student sv : svs) {
			sv.toString();
		}
	}
	
	
}

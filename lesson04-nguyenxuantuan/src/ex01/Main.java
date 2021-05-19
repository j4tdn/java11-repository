package ex01;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Student sv1 = new Student(1853, "Xuan Tuan", 10, 8);
		Student sv2 = new Student(2941, "Van Lam", 8, 7);
		Student sv3 = new Student();
		sv3 = Input();
		
		System.out.printf("\n%-10s %-20s %10s %10s %10s\n", "MSSV", "Ho ten", "Điem LT", "Điem TH", "Điem TB");
		System.out.printf("%-10s %-20s %10s %10s %10s\n", sv1.getId(), sv1.getName(), sv1.getTheoryMark()
														,sv1.getPracMark(), sv1.getMarkAvg());
		System.out.printf("%-10s %-20s %10s %10s %10s\n", sv2.getId(), sv2.getName(), sv2.getTheoryMark()
														,sv2.getPracMark(), sv2.getMarkAvg());
		System.out.printf("%-10s %-20s %10s %10s %10s\n", sv3.getId(), sv3.getName(), sv3.getTheoryMark()
														,sv3.getPracMark(), sv3.getMarkAvg());
		
	}
	
	private static Student Input(){
		Scanner sc = new Scanner(System.in);
		Student sv = new Student();
		System.out.println("Nhap ma sinh vien: ");
		sv.setId(sc.nextInt());
		sc.nextLine();
		System.out.println("Nhap ten: ");
		sv.setName(sc.nextLine());
		System.out.println("Nhap diem ly thuyet:");
		sv.setTheoryMark(sc.nextFloat());
		System.out.println("Nhap diem thuc hanh: ");
		sv.setPracMark(sc.nextFloat());
		return sv;
	}
	
}
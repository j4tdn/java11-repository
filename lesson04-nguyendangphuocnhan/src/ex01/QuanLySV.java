package ex01;

import java.util.Scanner;

public class QuanLySV {
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(01, "Nguyễn Nhân", 7.5f, 8f);
		SinhVien sv2 = new SinhVien(02, "Dụ Tiểu Vũ", 10f, 8.5f);

		SinhVien sv3 = new SinhVien();
		nhapSV(sv3);

		System.out.println("=====================================================================================");

		System.out.print("MSSV\t\t");
		System.out.print("Họ tên\t\t\t");
		System.out.print("Điểm LT\t\t");
		System.out.print("Điểm TH\t\t");
		System.out.println("Điểm TB\t\t");

		System.out.println("=====================================================================================");

		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}

	public static void nhapSV(SinhVien sv) {
		Scanner ip = new Scanner(System.in);

		System.out.print("Mã sinh viên 3: ");
		sv.setMaSV(Integer.parseInt(ip.nextLine()));

		System.out.print("Họ tên của sinh viên 3: ");
		sv.setHoTen(ip.nextLine());

		System.out.print("Điểm lý thuyết của sinh viên 3: ");
		sv.setDiemLT(Float.parseFloat(ip.nextLine()));

		System.out.print("Điểm thực hành của sinh viên 3: ");
		sv.setDiemTH(Float.parseFloat(ip.nextLine()));

	}
}

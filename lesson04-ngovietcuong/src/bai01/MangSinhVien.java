package bai01;

import java.util.ArrayList;
import java.util.Scanner;

public class MangSinhVien {
	ArrayList<SinhVien> a = new ArrayList<SinhVien>();

	public static void nhap(SinhVien sv) {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap ma sinh vien : ");
		sv.setMaSV(Integer.parseInt(ip.nextLine()));
		System.out.print("Nhap ho ten :");
		sv.setHoTen(ip.nextLine());
		System.out.print("Nhap diem LT : ");
		sv.setDiemLT(Float.parseFloat(ip.nextLine()));
		System.out.print("Nhap diem TH : ");
		sv.setDiemTH(Float.parseFloat(ip.nextLine()));
	}

	public static void in(SinhVien sv1, SinhVien sv2, SinhVien sv3) {
		System.out.print("MSSV \tHoTen \t\tDiemLT \tDiemTH\tDiemTB");
		System.out.print("\n" + sv1);
		System.out.print("\n" + sv2);
		System.out.print("\n" + sv3);
	}

	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(1, "Ngo Viet Cuong", 8, 9);
		SinhVien sv2 = new SinhVien(2, "Pham Thanh Dat", 9, 10);
		SinhVien sv3 = new SinhVien();
		nhap(sv3);
		in(sv1, sv2, sv3);
	}
}

package baitap;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		SV sv1 = new SV(01, "Phạm Sỹ Hoàng", 8, 8);
		SV sv2 = new SV(02, "Nguyễn Văn A", 10, 9);
		SV sv3 = new SV();
		Nhap(sv3);
		SV[] arr = new SV[3];
		arr[0] = sv1;
		arr[1] = sv2;
		arr[2] = sv3;
		Xuat(arr);
	}
	
	public static void Nhap(SV sv) {
		Scanner ip = new Scanner(System.in);
		System.out.println("=====NHẬP THÔNG TIN SINH VIÊN=====");
		
		System.out.print("Nhập mã số sinh viên: ");
		sv.setMssv(Integer.parseInt(ip.nextLine()));
		
		System.out.print("Nhập họ tên: ");
		sv.setHoten(ip.nextLine());
		
		System.out.print("Nhập điểm lý thuyết: ");
		sv.setDiemLT(Integer.parseInt(ip.nextLine()));
		
		System.out.print("Nhập điểm thực hành: ");
		sv.setDiemTH(ip.nextFloat());
	}
	
	public static void Xuat(SV[] sv) {
		System.out.println("\n\t\t\t=====DANH SÁCH SINH VIÊN=====");
		
		System.out.println("-------------------------------------------------------------------------------");
		System.out.println("MSSV\t\t" + "Họ tên\t\t\t" + "Điểm LT\t\t" + "Điểm TH\t\t" + "ĐiểmTB\t\t");
		System.out.println("-------------------------------------------------------------------------------");
		
		for(int i = 0;i< sv.length;i++) {
			System.out.println(sv[i].getMssv() + "\t\t" + sv[i].getHoten() + "\t\t" + sv[i].getDiemLT() + "\t\t"+ sv[i].getDiemTH() + "\t\t"+ sv[i].diemTB() + "\t\t");
		}
	}
}

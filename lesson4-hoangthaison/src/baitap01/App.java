package baitap01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien(1, "hoàng thái sơn", 7, 7);
		SinhVien sv2 = new SinhVien(2, "hoang anh tuan",8, 8.5f);
		
		SinhVien sv3 = Nhap();
		System.out.println("MSSV \t Họ Tên \t Điểm TH \t Điểm LT \t Điểm TH \t Điểm TB");
		
		System.out.println(sv1.MSSV + " \t " + sv1.NameSV + " \t " + sv1.DiemLT +" \t " + sv1.DiemTH + " \t " + TB(sv1.DiemLT,sv1.DiemTH));
		System.out.println(sv2.MSSV + " \t " + sv2.NameSV + " \t " + sv2.DiemLT +" \t " + sv2.DiemTH + " \t " + TB(sv2.DiemLT,sv2.DiemTH));
		System.out.println(sv3.MSSV + " \t " + sv3.NameSV + " \t " + sv3.DiemLT +" \t " + sv3.DiemTH + " \t " + TB(sv3.DiemLT,sv3.DiemTH));
			
		
		
	}
	private static SinhVien Nhap () {
		Scanner sc =  new Scanner(System.in);
		SinhVien sv3 = new SinhVien();
		System.out.println("Nhập MSSV : ");
		sv3.MSSV = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập Tên SV : ");
		sv3.NameSV = sc.nextLine();
		System.out.println("Điểm TL : ");
		sv3.DiemTH = Float.parseFloat(sc.nextLine());
		System.out.println("Diểm TH : ");
		sv3.DiemLT = Float.parseFloat(sc.nextLine());
		return sv3;
	}
	private static float TB(float LT,float TH) {
		
		return (LT+TH)/2;
		
	}
	

}

package bai04;

import java.util.Scanner;

public class NhanVien extends People{
   private String tenDonVi;
   
   public NhanVien() {
}

public NhanVien(String hoTen, String namSinh, double heSoLuong, String tenDonVi) {
	super(hoTen, namSinh, heSoLuong);
	this.tenDonVi = tenDonVi;
}

public String getTenDonVi() {
	return tenDonVi;
}

public void setTenDonVi(String tenDonVi) {
	this.tenDonVi = tenDonVi;
}
   
   @Override
	public String toString() {

		return "[NhanVien]\n" + super.toString() + tenDonVi + " " +Luong();
	}
   
   public double Luong() {
	   return getHeSoLuong()*1250000;
   }
   
   @Override
	public void nhap() {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap thong tin cho NhanVien");
		super.nhap();
		System.out.print("Nhap ten don vi: ");
		setTenDonVi(ip.nextLine());
	}
   
}

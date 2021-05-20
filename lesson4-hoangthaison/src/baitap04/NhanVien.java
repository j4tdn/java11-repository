package baitap04;

import java.util.Scanner;

public class NhanVien extends People{
	public String tendonvi;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String hoTen,int namSinh,double heSol,String tendonvi) {
		super(hoTen,namSinh,heSol);
		this.tendonvi = tendonvi;
	}

	public String getTendonvi() {
		return tendonvi;
	}

	public void setTendonvi(String tendonvi) {
		this.tendonvi = tendonvi;
	}

	public double luong() {
		return hesol*1250000;
	}
	@Override
	public String toString() {
		return "NhanVien [" +super.toString()+"tendonvi=" + tendonvi + luong() + "]";
	}
	@Override
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		super.Nhap();
		System.out.println("Tên đơn vị: ");
		setTendonvi(sc.nextLine());
	}
	

	
	

}

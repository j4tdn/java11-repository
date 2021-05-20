package baitap04;

import java.util.Scanner;

public class TruongPhong extends People {

	public int sonhanvien;
	
	public TruongPhong() {
		// TODO Auto-generated constructor stub
	}

	

	public TruongPhong(String hoTen,int namSinh,double heSol, int sonhanvien) {
		super(hoTen,namSinh,heSol);

		this.sonhanvien = sonhanvien;
	}

	@Override
	public String toString() {
		return "TruongPhong [" + super.toString()+ "sonhanvien" + sonhanvien + "]";
	} 

	@Override
	public void Nhap() {
		Scanner sc = new Scanner(System.in);
		super.Nhap();
		System.out.println("Số Nhân viên");
		setSonhanvien(Integer.parseInt(sc.nextLine()));
	}



	public int getSonhanvien() {
		return sonhanvien;
	}



	public void setSonhanvien(int sonhanvien) {
		this.sonhanvien = sonhanvien;
	}
}

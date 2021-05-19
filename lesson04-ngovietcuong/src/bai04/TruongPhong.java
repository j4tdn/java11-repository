package bai04;

import java.time.LocalDate;
import java.util.Scanner;

public class TruongPhong extends People {

	private int SLNV;

	public TruongPhong() {
		// TODO Auto-generated constructor stub
	}

	public TruongPhong(String hoTen, String namSinh, double heSoLuong, int sLNV) {
		super(hoTen, namSinh, heSoLuong);
		SLNV = sLNV;
	}

	public int getSLNV() {
		return SLNV;
	}

	public void setSLNV(int sLNV) {
		SLNV = sLNV;
	}

	@Override
	public String toString() {

		return "[TruongPhong]\n" + super.toString() + SLNV + " " + Luong();
	}

	public double Luong() {
		return getHeSoLuong() * 2200000;
	}
	
	@Override
	public void nhap() {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap thong tin cho Truong Phong");
		super.nhap();
		System.out.print("Nhap sl nhan vien: ");
		setSLNV(Integer.parseInt(ip.nextLine()));
	}
}

package bai04;

import java.time.LocalDate;
import java.util.Scanner;

public class GiamDoc extends People {
	private double hscv;

	public GiamDoc() {
	}

	public GiamDoc(String hoTen, String namSinh, double heSoLuong, double hscv) {
		super(hoTen, namSinh, heSoLuong);
		this.hscv = hscv;
	}

	public double getHscv() {
		return hscv;
	}

	public void setHscv(double hscv) {
		this.hscv = hscv;
	}

	@Override
	public String toString() {

		return "[GiamDoc]\n" + super.toString() + hscv + " " + Luong();
	}

	public double Luong() {
		return (getHeSoLuong() + hscv) * 3000000;
	}
	
	@Override
	public void nhap() {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap thong tin cho Giam Doc");
		super.nhap();
		System.out.print("Nhap hs chuc vu: ");
		setHscv(Double.parseDouble(ip.nextLine()));
	}

}

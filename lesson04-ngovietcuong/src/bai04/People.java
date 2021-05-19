package bai04;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class People {
	private String hoTen;
	private String namSinh;
	private double heSoLuong;

	public People() {
	}

	public People(String hoTen, String namSinh, double heSoLuong) {
		super();
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.heSoLuong = heSoLuong;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	public double getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	@Override
	public String toString() {
		return hoTen + " " + namSinh + " " + heSoLuong + " ";
	}

	public abstract double Luong();

	public void nhap() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap ho ten: ");
		setHoTen(ip.nextLine());
		System.out.print("Nhap nam sinh: ");
		setNamSinh(ip.nextLine());
		System.out.print("Nhap hs luong: ");
		setHeSoLuong(Integer.parseInt(ip.nextLine()));
	}

}

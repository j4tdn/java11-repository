package bt4;

import java.util.Scanner;

public abstract class People {
	private String hoTen;
	private int namSinh;
	private int heSoLuong;
	private int heSoChucVu;

	public People() {

	}

	public People(String hoTen, int namSinh, int heSoLuong, int heSoChucVu) {
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.heSoLuong = heSoLuong;
		this.heSoChucVu = heSoChucVu;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public int getHeSoLuong() {
		return heSoLuong;
	}

	public void setHeSoLuong(int heSoLuong) {
		this.heSoLuong = heSoLuong;
	}

	public int getHeSoChucVu() {
		return heSoChucVu;
	}

	public void setHeSoChucVu(int heSoChucVu) {
		this.heSoChucVu = heSoChucVu;
	}

	@Override
	public String toString() {
		return "People [hoTen=" + hoTen + ", namSinh=" + namSinh + ", heSoLuong=" + heSoLuong + ", heSoChucVu="
				+ heSoChucVu + "]";
	}

	abstract void input();

	abstract double luong();

	abstract void output();
}

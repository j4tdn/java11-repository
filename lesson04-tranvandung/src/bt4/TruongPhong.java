package bt4;

import java.util.Scanner;

public class TruongPhong extends People {
	private int nhanVienQuanLy;

	public TruongPhong() {

	}

	public TruongPhong(int nhanVienQuanLy) {

		this.nhanVienQuanLy = nhanVienQuanLy;
	}

	public int getNhanVienQuanLy() {
		return nhanVienQuanLy;
	}

	public void setNhanVienQuanLy(int nhanVienQuanLy) {
		this.nhanVienQuanLy = nhanVienQuanLy;
	}

	@Override
	double luong() {
		return (getHeSoLuong() + getHeSoChucVu() * 2200000);
	}

	@Override
	public void input() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap Ho Ten Truong Phong: ");
		setHoTen(ip.nextLine());
		
		System.out.print("Nhap Nam Sinh: ");
		setNamSinh(ip.nextInt());
		ip.nextLine();
		
		System.out.print("Nhap He So Luong: ");
		setHeSoLuong(ip.nextInt());
		
		System.out.print("Nhap He So Chuc Vu: ");
		setHeSoChucVu(ip.nextInt());
		
		System.out.print("Nhap So Nhan Vien Quan Ly: ");
		setNhanVienQuanLy(ip.nextInt());
	}

	@Override
	public String toString() {
		return "TruongPhong [nhanVienQuanLy=" + nhanVienQuanLy + "]";
	}

	@Override
	void output() {
		System.out.printf("\n%-20s%-20s%10s%20s%20s%25s\n", "Hoten", "Nam Sinh", "He So Luong", "He So Chuc Vu", "Nhan Vien Quan Ly", "Luong");
		System.out.println("=================================================================================================================");
		System.out.printf("%-20s%-20s%8s%20s%20s%25s\n",this.getHoTen(), this.getNamSinh(), this.getHeSoLuong(), this.getHeSoChucVu(), this.getNhanVienQuanLy(), luong());
		System.out.println();
	}

}

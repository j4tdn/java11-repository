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
		System.out.println("nhap ho ten truong phong: ");
		setHoTen(ip.nextLine());
		
		System.out.println("nhap nam sinh: ");
		setNamSinh(ip.nextInt());
		ip.nextLine();
		
		System.out.println("nhap he so luong: ");
		setHeSoLuong(ip.nextInt());
		
		System.out.println("nhap he so chuc vu: ");
		setHeSoChucVu(ip.nextInt());
		
		System.out.println("nhap so nhan vien quan ly: ");
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

package bt4;

import java.util.Scanner;

public class NhanVien extends People {
	private String donVi;

	public NhanVien() {

	}

	public NhanVien(String donVi) {
		this.donVi = donVi;
	}

	public String getDonVi() {
		return donVi;
	}

	public void setDonVi(String donVi) {
		this.donVi = donVi;
	}

	@Override
	public void input() {
		Scanner ip = new Scanner(System.in);
		System.out.println("nhap ho ten nhan vien: ");
		setHoTen(ip.nextLine());

		System.out.println("nhap nam sinh: ");
		setNamSinh(ip.nextInt());
		ip.nextLine();

		System.out.println("nhap he so luong: ");
		setHeSoLuong(ip.nextInt());

		System.out.println("nhap he so chuc vu: ");
		setHeSoChucVu(ip.nextInt());
		ip.nextLine();

		System.out.println("nhap ten don vi(phong/ban): ");
		setDonVi(ip.nextLine());

	}

	@Override
	double luong() {
		return (getHeSoLuong() + getHeSoChucVu() * 1250000);
	}

	@Override
	public String toString() {
		return "NhanVien [donVi=" + donVi + "]";
	}

	@Override
	void output() {
		 System.out.printf("\n%-20s%-20s%10s%20s%20s%20s\n", "Hoten", "Nam Sinh", "He So Luong", "He So Chuc Vu", "Don Vi", "Luong");
		 System.out.println("==============================================================================================================================");
		 System.out.printf("%-20s%-20s%8s%20s%20s%20s\n",this.getHoTen(), this.getNamSinh(), this.getHeSoLuong(), this.getHeSoChucVu(), this.getDonVi(), luong());
		 System.out.println();
	}
}

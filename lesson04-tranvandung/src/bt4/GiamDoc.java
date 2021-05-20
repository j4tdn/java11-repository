package bt4;

import java.util.Scanner;

public class GiamDoc extends People {

	@Override
	public void input() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap Ho Ten Giam Doc: ");
		setHoTen(ip.nextLine());

		System.out.print("Nhap Nam Sinh: ");
		setNamSinh(ip.nextInt());

		System.out.print("Nhap He So Luong: ");
		setHeSoLuong(ip.nextInt());

		System.out.print("Nhap He So Chuc Vu: ");
		setHeSoChucVu(ip.nextInt());
	}

	@Override
	double luong() {
		return (getHeSoLuong() + getHeSoChucVu()) * 3000000;
	}

	@Override
	void output() {
		
		System.out.printf("\n%-20s%-20s%10s%20s%25s\n", "Hoten", "Nam Sinh", "He So Luong", "He So Chuc Vu", "luong");
		System.out.println("===================================================================================================");
		System.out.printf("%-20s%-20s%8s%20s%25s\n",this.getHoTen(), this.getNamSinh(), this.getHeSoLuong(), this.getHeSoChucVu(), luong());
		System.out.println();
	}
}

package bt4;

import java.util.Scanner;

public class GiamDoc extends People {

	@Override
	public void input() {
		Scanner ip = new Scanner(System.in);
		System.out.println("nhap ho ten giam doc:");
		setHoTen(ip.nextLine());

		System.out.println("nhap nam sinh:");
		setNamSinh(ip.nextInt());

		System.out.println("nhap he so luong:");
		setHeSoLuong(ip.nextInt());

		System.out.println("nhap he so chuc vu:");
		setHeSoChucVu(ip.nextInt());
	}

	@Override
	double luong() {
		return (getHeSoLuong() + getHeSoChucVu() * 3000000);
	}

	@Override
	void output() {
		
		System.out.printf("\n%-20s%-20s%10s%20s%25s\n", "Hoten", "Nam Sinh", "He So Luong", "He So Chuc Vu", "luong");
		System.out.println("===================================================================================================");
		System.out.printf("%-20s%-20s%8s%20s%25s\n",this.getHoTen(), this.getNamSinh(), this.getHeSoLuong(), this.getHeSoChucVu(), luong());
		System.out.println();
	}
}

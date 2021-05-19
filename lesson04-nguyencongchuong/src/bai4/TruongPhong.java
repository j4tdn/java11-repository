package bai4;

import java.util.Scanner;

public class TruongPhong extends People {
	@Override
	public double Luong() {
		double luong = 0;

		luong = (super.getHsl() + super.getHscv()) * 2200000;

		return luong;
	}

	@Override
	void input() {
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhập tên Trưởng phòng: ");
		setName(ip.nextLine());
		System.out.print("Nhập id: ");
		setId(ip.nextInt());
		System.out.print("Nhập hệ số lương: ");
		setHsl(ip.nextFloat());
		System.out.print("Nhập hệ số chức vụ: ");
		setHscv(ip.nextFloat());
	}
	
}

package bai01;

import java.util.Scanner;

public class Bai01 {

	public static void main(String[] args) {
		int xO = 0;
		int yO = 0;
		Scanner ip = new Scanner(System.in);
		System.out.print("Nhap ban kinh: ");
		int r = ip.nextInt();
		System.out.print("Nhap hoanh do diem A: ");
		int xA = ip.nextInt();
		System.out.print("Nhap tung do diem A: ");
		int yA = ip.nextInt();

		Pos pos = khoangCach(xO, yO, xA, yA, r);
          
		if (pos == Pos.ONSIDE) {
			System.out.println("A(xA, yA) = (" + xA + ", " + yA + ")");
			System.out.println(Pos.ONSIDE.value);
		}
		if (pos == Pos.INSIDE) {
			System.out.println(Pos.INSIDE.value);
		}
		if (pos == Pos.OUTSIDE) {
			System.out.println(Pos.OUTSIDE.value);
		}

	}

	public static Pos khoangCach(int xO, int yO, int xA, int yA, int r) {

		double z = (Math.sqrt(Math.pow(xA - xO, 2) + Math.pow(yA - xO, 2)));

		if (z == r) {
			return Pos.ONSIDE;
		}
		if (z > r) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
}

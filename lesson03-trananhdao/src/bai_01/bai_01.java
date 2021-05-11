package bai_01;

import java.util.Scanner;

public class bai_01 {

	public static void main(String[] args) {
		System.out.println(" moi nhap tam  O(x,y)= ");
		int xO = nhap(0);
		int y0 = nhap(0);
		System.out.print("moi nhap R= ");
		int r = nhap(0);
		System.out.println(" moi nhap diem A(x,y)= ");
		int xA = nhap(0);
		int yA = nhap(0);
		System.out.println("========================================");
		Position pos = getPos(xA, yA, xO, yA, r);
		if (pos == pos.TREN) {
			System.out.println("(xA,yA) = (" + xA + " ," + yA + ")");
			System.out.println(Position.TREN);
		}
		if (pos == pos.NGOAI) {
			System.out.println(Position.NGOAI);
		} else {
			System.out.println(Position.TRONG);
		}

	}

	private static int nhap(int x) {
		Scanner ip = new Scanner(System.in);
		x = Integer.parseInt(ip.nextLine());
		return x;
	}

	private static Position getPos(int xA, int yA, int xO, int yO, int r) {
		double dis = Math.sqrt(Math.pow(xA - xO, 2) + Math.pow(yA - yO, 2));
		if (dis > r) {
			return Position.NGOAI;
		}
		if (dis < r) {
			return Position.TRONG;
		} else {
			return Position.TREN;
		}
	}
}

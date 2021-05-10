package demo;

import java.util.Scanner;

import beans.Circle;
import enumeration.Pos;
import utils.CircleUtils;

public class Ex01Main {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		Circle crl1 = new Circle();
		System.out.print("Nhap x = ");
		crl1.setX(ip.nextInt());  
		System.out.print("Nhap y = ");
		crl1.setY(ip.nextInt());  
		System.out.print("Nhap ban kinh R = ");
		int r = ip.nextInt();
		System.out.println("Nhap tam duong tron :");
		System.out.print("x0 = ");
		int x0 = ip.nextInt();
		System.out.print("y0 = ");
		int y0 = ip.nextInt();
		ip.close();
		System.out.println("=========================");

		Pos pos = CircleUtils.getPos(crl1, x0, y0, r);
		if (pos == Pos.INSIDE) {
			System.out.println("VALUE : " + pos.value);
			System.out.println("(xA,xO) = (" + crl1.getX() + " ," + crl1.getY() + ")");
		}else if (pos == Pos.ONSIDE) {
			System.out.println("VALUE : " + pos.value);
			System.out.println("(xA,xO) = (" + crl1.getX() + " ," + crl1.getY() + ")");
		}else {
			System.out.println("VALUE : " + pos.value);
			System.out.println("(xA,xO) = (" + crl1.getX() + " ," + crl1.getY() + ")");
		}

	}
}

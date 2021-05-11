package baitap13;

import java.util.Scanner;

public class Bt01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.print("nhap ban kinh R: ");
		int R = ip.nextInt();
		System.out.print("nhap toa do tam O: ");
		int xO = ip.nextInt();
		int yO = ip.nextInt();
		System.out.print("nhap toa do diem A: ");
		int x = ip.nextInt();
		int y = ip.nextInt();
		double distance = Math.sqrt(Math.pow((x - xO), 2) + Math.pow((y - yO), 2));
		if (distance <= R) {
			System.out.println("A thuoc duong tron");
		}
		else
			System.out.println("A khong thuoc duong tron");
	}
}

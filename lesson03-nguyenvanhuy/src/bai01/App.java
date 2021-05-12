package bai01;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Circle circle = new Circle();
		Point point = new Point();
		Scanner input = new Scanner(System.in);

		System.out.println("nhap duong tron: ");
		System.out.println("nhap x0: ");
		circle.setx0(input.nextInt());
		System.out.println("nhap y0: ");
		circle.sety0(input.nextInt());
		System.out.println("nhap ban kinh: ");
		circle.setRadius(input.nextInt());

		System.out.println("nhap diem A:");
		System.out.println("nhap xA: ");
		point.setxA(input.nextInt());
		System.out.println("nhap yA: ");
		point.setyA(input.nextInt());

		System.out.println("vi tri diem A: " + circle.PosOfPoint(circle, point));
	}
}

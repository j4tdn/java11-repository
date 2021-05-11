package bai1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Circle c = new Circle();
		Point p = new Point();
		
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập vào tâm đường tròn:");
		System.out.print("xO: ");
		c.setxO(ip.nextInt());
		System.out.print("yO: ");
		c.setyO(ip.nextInt());
		System.out.println("nhập bán kính R: ");
		System.out.print("R: ");
		c.setR(ip.nextInt());
		
		System.out.println("Nhập vào điểm A: ");
		System.out.print("xA: ");
		p.setxA(ip.nextInt());
		System.out.print("yA: ");
		p.setyA(ip.nextInt());
		
		System.out.println("Vị trí điểm A so với đường tròn: ");
		System.out.println(CheckUtil.getPos(c, p));
		
	}

}

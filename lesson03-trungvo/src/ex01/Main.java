package ex01;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		PointA p1 = new PointA();
		System.out.println("Nhap xA: ");
		p1.setX(ip.nextInt());
		System.out.println("Nhap yA: ");
		p1.setY(ip.nextInt());
		
		
		System.out.println("Nhap ban kinh r: ");
		int r = ip.nextInt();
		
		int xO = 0;
		int yO = 0;
		
		Pos pos = CircleUtils.getPos(p1, xO, yO, r);
		if (pos == Pos.OUTSIDE) {
				System.out.println("value: " + pos.value);	
			}
			else if (pos == Pos.ONSIDE) {
				System.out.println("value: " + pos.value);
				
			}
			else {
				System.out.println(pos.value);
			}
		}
			
}



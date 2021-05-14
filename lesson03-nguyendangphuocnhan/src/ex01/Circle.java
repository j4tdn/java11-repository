package ex01;

import java.util.Scanner;


public class Circle {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		Point pA = new Point();
		Point pO = new Point();
				
		System.out.print("Input xO: ");
		pO.setX(Integer.parseInt(ip.nextLine()));
		System.out.print("Input yO: ");
		pO.setY(Integer.parseInt(ip.nextLine()));
		
		System.out.print("Input r: ");
		int r = Integer.parseInt(ip.nextLine());
		
		System.out.print("Input xA: ");
		pA.setX(Integer.parseInt(ip.nextLine()));
		
		System.out.print("Input yA: ");
		pA.setY(Integer.parseInt(ip.nextLine()));
		
		Pos pos = CircleUtils.getPos(pA, pO, r);
		
		if (pos == Pos.INSIDE) {
			System.out.print("A is inside of the circle. The coordinates of A is: ");
			System.out.println("(xA, yA) = (" + pA.getX() + ", " + pA.getY() + ")");
		}else if (pos == Pos.ONSIDE) {
			System.out.print("A is onside of the circle. The coordinates of A is: ");
			System.out.println("(xA, yA) = (" + pA.getX() + ", " + pA.getY() + ")");
		}else {
			System.out.print("A is outside of the circle. The coordinates of A is: ");
			System.out.println("(xA, yA) = (" + pA.getX() + ", " + pA.getY() + ")");
		}
		
}
}
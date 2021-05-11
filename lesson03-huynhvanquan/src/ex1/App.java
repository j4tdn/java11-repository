package ex1;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int radius;
		Point O = new Point(0, 0);
		Point A = new Point();

		System.out.println("Enter point A: ");
		A.setX(sc.nextInt());
		A.setY(sc.nextInt());
		System.out.println("Enter radius: ");
		radius = sc.nextInt();
		Pos pos = PointUtils.getPos(O, radius, A);
		System.out.println(pos.value);
	}
}

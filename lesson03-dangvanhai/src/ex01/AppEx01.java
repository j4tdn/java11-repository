package ex01;

import java.util.Scanner;

/*
 * Check position of another point relative to the circle
 */
public class AppEx01 {
	public static void main(String[] args) {
		// Declare circle and points
		Circle circle;
		Point centerCircle = new Point();
		Point anotherPoint = new Point();
		Scanner scanner = new Scanner(System.in);

		// Enter circle's parameters
		System.out.println("\tNhap thong so cho duong tron");
		System.out.print("xO: ");
		centerCircle.setX(scanner.nextInt());
		System.out.print("yO: ");
		centerCircle.setY(scanner.nextInt());
		System.out.print("R : ");
		circle = new Circle(centerCircle, scanner.nextInt());

		// Enter parameters of another point
		System.out.println("\tNhap toa do diem A");
		System.out.print("xA: ");
		anotherPoint.setX(scanner.nextInt());
		System.out.print("yA: ");
		anotherPoint.setY(scanner.nextInt());
		scanner.close();

		// Print Result
		System.out.println("\n\t===============");
		System.out.println("Duong tron\t: " + circle);
		System.out.println("Diem A\t\t: " + anotherPoint);
		System.out.println("=> " + circle.PosOfPoint(anotherPoint));
	}
}

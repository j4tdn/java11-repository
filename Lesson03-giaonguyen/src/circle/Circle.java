package circle;

import java.util.Scanner;

public class Circle {
	public static void main(String[] args) {
		
		int center_x;
		int center_y;
		int radius;
		int point_x;
		int point_y;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input center: ");
		center_x = sc.nextInt();
		center_y = sc.nextInt();
		System.out.println(" Input radius: ");
		radius = sc.nextInt();
		
		System.out.println("Input point: ");
		point_x = sc.nextInt();
		point_y = sc.nextInt();
		
		if (Math.pow(point_x - center_x, 2) + Math.pow(point_y - center_y, 2) <= Math.pow(radius, 2))
			System.out.println("-> In the cricle");
		else System.out.println("-> Not in the cricle");
		
	}
}

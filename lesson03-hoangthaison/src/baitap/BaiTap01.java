package baitap;

import java.util.Scanner;

public class BaiTap01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập tọa độ tâm O: ");
		Point_01 O = new Point_01(
				Integer.parseInt(sc.nextLine()),
				Integer.parseInt(sc.nextLine())
		);
		System.out.println("Tọa Độ A: ");
		Point_01 A = new Point_01(	
				Integer.parseInt(sc.nextLine()),
				Integer.parseInt(sc.nextLine())
		);
		
		System.out.println("Bán kính R: ");
		int R = Integer.parseInt(sc.nextLine());
		Pos_01 p= getPost(O,A,R);
		if(p == Pos_01.INSIDE) System.out.println("Inside");
		else
		if(p == Pos_01.ONSIDE) System.out.println("Onside");
		else System.out.println("Outside");
		
		
	}
	private static Pos_01 getPost (Point_01 O,Point_01 A, int R) {
		double distance = Math.sqrt(Math.pow(A.x-O.x,2)+Math.pow(A.y-O.y,2));
		if(distance == R) {
			return Pos_01.ONSIDE;
		}
		if(distance > R) {
			return Pos_01.OUTSIDE;
		}
		return Pos_01.INSIDE;
		
		
	}

}

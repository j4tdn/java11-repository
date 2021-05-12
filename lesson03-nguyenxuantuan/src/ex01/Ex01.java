package ex01;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		System.out.println("Nhap xO:");
		int xO = Integer.parseInt(ip.nextLine());
		System.out.println("Nhap yO:");
		int yO = Integer.parseInt(ip.nextLine());
		System.out.println("Nhap R:");
		int R = Integer.parseInt(ip.nextLine());
		
		System.out.println("Nhap xA:");
		int xA = Integer.parseInt(ip.nextLine());
		System.out.println("Nhap yA:");
		int yA = Integer.parseInt(ip.nextLine());
		System.out.println(isOnside(xA, yA, xO, yO, R));
		
	}
	private static boolean isOnside(int xA, int yA, int xO, int yO, int R) {
    	double distance = Math.sqrt(Math.pow((xA - xO), 2) + Math.pow((yA - yO), 2));
    	if(distance == R) {
    		return true;
       	}
    	return false;
    }

}

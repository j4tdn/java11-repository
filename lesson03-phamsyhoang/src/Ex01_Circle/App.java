package Ex01_Circle;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		
		System.out.println("Nhập tọa độ tâm O của đường tròn: ");	
		Point O = new Point(ip.nextFloat(), ip.nextFloat());
	
		System.out.println("Nhập bán kính R của đường tròn: ");	
		Float R = ip.nextFloat();
		
		System.out.println("Nhập tọa độ điểm A: ");	
		Point A = new Point(ip.nextFloat(), ip.nextFloat());
		
		System.out.println("A nằm " + PosUtils.getPos(A, O, R).value + " đường tròn" );
	}
}

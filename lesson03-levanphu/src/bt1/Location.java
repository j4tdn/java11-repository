package bt1;
import java.util.Scanner;
import bt1.Circle;
import bt1.Pos;
import bt1.Utils;
public class Location {
	public static void main(String[] args) {
		Scanner ip = new Scanner(System.in);
		Circle crl = new Circle();
		System.out.print("Nhap x = ");
		crl.setX(ip.nextInt());  
		System.out.print("Nhap y = ");
		crl.setY(ip.nextInt());  
		System.out.print("x0 = ");
		int x0 = ip.nextInt();
		System.out.print("y0 = ");
		int y0 = ip.nextInt();
		System.out.print("Nhap ban kinh R = ");
		int r = ip.nextInt();
		ip.close();
		System.out.println("===============");

		Pos pos = Utils.getPos(crl, x0, y0, r);
		if (pos == Pos.INSIDE) {
			System.out.println("VALUE : " + pos.value);
			System.out.println("(xA,xO) = (" + crl.getX() + " ," + crl.getY() + ")");
		}else if (pos == Pos.ONSIDE) {
			System.out.println("VALUE : " + pos.value);
			System.out.println("(xA,xO) = (" + crl.getX() + " ," + crl.getY() + ")");
		}else {
			System.out.println("VALUE : " + pos.value);
			System.out.println("(xA,xO) = (" + crl.getX() + " ," + crl.getY() + ")");
		}

	}

}

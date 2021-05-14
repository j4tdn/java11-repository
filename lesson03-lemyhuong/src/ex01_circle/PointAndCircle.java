package ex01_circle;

public class PointAndCircle {
	public static void main(String[] args) {
		Point p = new Point(3, 4);
		Point o = new Point(0, 0);
		int r = 5;

		Pos pos = PosHelper.getPos(p, o, r);

		if (pos == Pos.ONSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" + p.getX() + ", " + p.getY() + ")");
		}
		
		if (pos == Pos.INSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" + p.getX() + ", " + p.getY() + ")");
		}

	}

}

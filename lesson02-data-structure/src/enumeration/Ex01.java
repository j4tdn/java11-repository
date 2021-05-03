package enumeration;

public class Ex01 {
	public static void main(String[] args) {
<<<<<<< HEAD
		int xA = 3;
		int yA = 4;
		int xO = 0;
		int yO = 0;
		int R = 5;
		Pos pos = getPos(xA, yA, xO, yO, R);
		
		if (pos == pos.ONSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" + xA + ", " + yA + ")");
		}
	}
	
	private static Pos getPos(int xA, int yA, int xO, int yO, int R) {
		double distance = Math.sqrt(Math.pow((xA - xO), 2) + Math.pow((yA -yO),2));
=======
		int yA = 4;
		int xA = 3;
		int x0 = 0;
		int y0 = 0;
		int R = 5;
		Pos pos = getPos (xA, yA, x0, y0, R);
		
		// ==: stack compare
		if (pos == Pos.ONSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" +xA + "," + yA + ")");
		}
				
	}
	private static Pos getPos(int xA, int yA, int x0, int y0, int R) {
		double distance = Math.sqrt(Math.pow((xA - x0), 2) + Math.pow((yA - y0), 2));
>>>>>>> ba78b3a (lesson02-03 02.05.2021)
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
<<<<<<< HEAD
=======

>>>>>>> ba78b3a (lesson02-03 02.05.2021)
}

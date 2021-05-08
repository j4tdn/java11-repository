package emumeration;

public class Ex01 {
	public static void main(String[] args) {
		int xA = 3;
		int yA = 4;
		int xO = 0;
		int yO = 0;
		int R = 5;
		Pos pos = getPos(xA, yA, xO, yO, R);
		if (pos == Pos.ONSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" + xA + "," + yA + ")");
		}

		
	}
	private static Pos getPos(int xA, int yA, int x0, int y0, int R) {
		double distance = Math.sqrt(Math.pow(xA - x0, 2) + Math.pow(yA - y0, 2));
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if ( distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
	
}

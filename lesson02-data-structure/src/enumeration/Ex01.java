package enumeration;

public class Ex01 {
//	private static String ONSIDE = "TREN";
//	private static String INSIDE = "TRONG";
//	private static String OUTSIDE = "NGOAI";

	public static void main(String[] args) {
		// A(xA, yA)
		// O(xO, yO)
		// R = 5

		// TRONG:
		// tREN: => in ra tOAdO
		// ngoai:

		int xA = 3;
		int yA = 5;
		int xO = 0;
		int yO = 0;
		int R = 5;
//		String pos = getPos(3, 3, 0, 0, 5);
		Pos pos = getPos(xA, yA, xO, yO, R);

//		System.out.println("pos: " + pos);
		// ==: STACK COMPARE
		if (pos == pos.ONSIDE) {
//			System.out.println("(xA, yA) = (" + 3 + ", " + 5 + ")");
			System.out.println("(xA, yA) = (" + xA + ", " + yA + ")");

		}
	}

	private static Pos getPos(int xA, int yA, int xO, int yO, int R) {
		double distance = Math.sqrt(Math.pow(xA - xO, 2) + Math.pow((yA - yO), 2));

		if (distance == R) {
			// hardcode
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
}	

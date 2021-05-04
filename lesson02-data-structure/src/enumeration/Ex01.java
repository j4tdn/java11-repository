package enumeration;

public class Ex01 {

	// public static String ONSIDE = "TREN";
	// public static String INSIDE = "TRONG";
	// public static String OUTSIDE = "NGOAI";

	public static void main(String[] args) {
		// A(xA, yA)
		// O(xO, yO) R = 5

		// TRONG:
		// TREN: => IN RA ToaDo
		// NGOAI:

		int xA = 3;
		int yA = 4;
		int xO = 0;
		int yO = 0;
		int R = 5;

		Pos pos = getPos(3, 4, 0, 0, 5);
		// ==: stack compare
		if (pos == Pos.ONSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" + xA + ", " + yA + ")");
		}
	}

	private static Pos getPos(int xA, int yA, int xO, int yO, int R) {
		// Math.pow(a, b): ham mu, a mu b
		double distance = Math.sqrt(Math.pow((xA - xO), 2) + Math.pow((yA - yO), 2));

		
		//có thể bỏ else khi if có return
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;

	}

}

package enumeration;

public class Ex01 {
	// private static String ONSIDE = "TREN";
		// private static String INSIDE = "TRONG";
		// private static String OUTSIDE = "NGOAI";
		

		public static void main(String[] args) {
			int xA = 3;
			int yA = 4;
			int xO = 0;
			int yO = 0;
			int R = 5;
			Pos pos = getPos(xA, yA, xO, yO, R);
			if (pos == Pos.INSIDE) {
				System.out.println("Pos: " + pos.value);
				System.out.println("(xA, yA) = (" + xA + ", " + yA + ")");
			}
		}
		private static Pos getPos(int xA, int yA, int xO, int yO, int R) {
			double distance = Math.sqrt(Math.pow((xA - xO), 2) + Math.pow((yA - yO), 2));
			if (distance == R) {
				return Pos.INSIDE;
			}
			if (distance > R) {
				return Pos.ONSIDE;
			}
			return Pos.OUTSIDE;

		}

}

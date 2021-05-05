package enumeration;

public class Ex01 {
	public static void main(String[] args) {
		// A(xA,yA)
		// O(xO, yO) R=5
		// TRONG:
		// TREN: IN RA ToaDo
		// NGOAI:
		int xA = 3;
		int yA = 4;
		int xO = 0;
		int yO = 0;
		int R = 5;
		Pos pos = getPos(xA, yA, xO, yO, R);
		
		// ==:stack compare
		if (pos == pos.ONSIDE) {
			System.out.println("(xA,yA) =(" + xA + ", " + yA + ")");
			System.out.println(Pos.ONSIDE.value);
		}
	}

	private static Pos getPos(int xA, int yA, int xO, int yO, int R) {
		double distance = Math.sqrt(Math.pow(xA - xO, 2) + Math.pow(yA - yO, 2));
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}

}

package enumeration;

public class Ex01 {
	public static void main(String[] args) {
		int xA = 3;
		int yA = 4;
		int x0 = 0;
		int y0 = 0;
		int R = 5;
		Pos pos = getPost(xA, yA, x0, y0, R);

		//
		if (pos == Pos.ONSIDE) {
			System.out.println(pos.value);
		}
	}

	private static Pos getPost(int xA, int yA, int x0, int y0, int R) {
		double distance = Math.sqrt(Math.pow(xA - x0, 2) + Math.pow(yA - y0, 2));
		System.out.println(distance);
		if (distance == R) {
			return Pos.ONSIDE;
		}
		if (distance > R) {
			return Pos.OUTSIDE;
		}
		return Pos.INSIDE;
	}
}

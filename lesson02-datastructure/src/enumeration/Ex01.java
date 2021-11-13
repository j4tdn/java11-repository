package enumeration;

public class Ex01 {

	// CirclePostition: ENUMeration
	// INSIDE,OUTSIDE,ONSIDE

	public static void main(String[] args) {
		// A:xa,ya;
		// Circle 0,x0,y0-R
		// Point: x,y
		// Point pA= new Point(xa,ya)
		Pointt pA = new Pointt(3,4);
		Pointt pO = new Pointt(0, 0);
		int R = 5;
		Position pos = getPos(pA, pO, R);
		System.out.println("pos: " + pos);
		if (pos == Position.INSIDE) {
			System.out.println("Calculate");
		}
	}

	private static Position getPos(Pointt point, Pointt pO, int R) {
		double distance = Math.sqrt(Math.pow((point.x - pO.x), 2) + Math.pow((point.y - pO.y), 2));
		if (distance < R) {
			// hardcode
			return Position.INSIDE;
		}
		if (distance == R) {
			return Position.ONSIDE;
		}
		return Position.OUTSIDE;
	}
}
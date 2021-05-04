package enumeration;

public class Ex01 {
	public static void main(String[] args) {
		int xA = 3;
		int yA = 4;
		int xo = 0;
		int yo = 0;
		int R = 5;
		Pos pos = getPos(xA, yA, xo, yo, R);
		if (pos == Pos.ONSIDE) {
			System.out.println("VALUE: " + pos.value);
			System.out.println("(xA, yA) = (" + xA + ", " + yA + ")");
		}
		
		
	} 
private static Pos getPos(int xA, int yA , int xo, int yo, int R) {
	double distance = Math.sqrt(Math.pow(xA - xo, 2) + Math.pow(yA - yo, 2));
	if(distance == R) {
		return Pos.ONSIDE;
	}
	if (distance > R) {
		return Pos.OUTSIDE;
	}
	return Pos.INSIDE;
	
		
	}
	
	
}

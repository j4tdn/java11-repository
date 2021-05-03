package enumeration;

public class Ex01_Practice {
	public static void main(String[] args) {
		int xA = 3;
		int yA = 4;
		int xO = 0;
		int yO = 0;
		int R = 5;
		
		Pos_Practice pos = getPos(xA, yA, xO, yO, R);
		if(pos == Pos_Practice.ONSIDE) {
			System.out.println(pos.value);
		}
	}
	public static Pos_Practice getPos(int xA, int yA, int xO, int yO, int R) {
		double distance = Math.sqrt(Math.pow((xA - xO), 2) + Math.pow((yA - yO), 2));
		if(distance == R) {
			return Pos_Practice.ONSIDE;
		} 
		if(distance < R) {
			return Pos_Practice.INSIDE;
		}
		return Pos_Practice.OUTSIDE;
	}
}

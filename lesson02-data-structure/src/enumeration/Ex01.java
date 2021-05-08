package enumeration;

public class Ex01 {
	public static void main(String[] args) {
		
		String pos =getPos(3,3,0,0,5);
		System.out.println("pos :" + pos);
	}
	
	private static String getPos(int xA, int yA, int xO, int yO, int R) {
		double distance = Math.sqrt(Math.pow(xA-xO,2) + Math.pow(yA-yO,2));
		
		if (distance == R) {
			return "TREN";
		} else {
			if(distance > R) {
			return "Ngoai";
		} else {
			return "trong";
	}
		}
	}
}

	
	


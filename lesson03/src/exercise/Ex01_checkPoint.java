package exercise;

public class Ex01_checkPoint {
	public static void main(String[] args) {
		float xCenter = 0;
		float yCenter = 0;
		int R = 5;
		float xA = 3;
		float yA = 4;

		if (checkPoint(xCenter, yCenter, R, xA, yA)) {
			System.out.println("Point A belongs to the circle");
		} else
			System.out.println("Point A doesn't belongs to the circle");

	}

	private static boolean checkPoint(float xCenter, float yCenter, float R, float x, float y) {
		double distance = Math.sqrt(Math.pow(xCenter - x, 2) + Math.pow(yCenter - y, 2));
		if (distance == R)
			return true;
		return false;
	}

}

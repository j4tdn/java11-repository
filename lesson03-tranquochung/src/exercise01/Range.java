package exercise01;

public class Range {
	public static void main(String[] args) {
		Point p = new Point(3, 2);
		Circle c = new Circle(new Point(7, 8), 7);
		System.out.println(c.checkLocation(p));
	}
}

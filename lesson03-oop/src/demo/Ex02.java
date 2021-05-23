package demo;
import bean.Box;
public class Ex02 {
	public static void main(String[] args) {
		// how many object will be created following
		
		int a = 10;
		Integer b = 20; // 1
		Integer c = new Integer(30); // 2
		Integer d = b;
		
		String e = "text"; // 3
		String f = e;
		String g = new String("value"); // 4
		
		Box box1 = new Box(); // 5
		Box box2 = null;
		Box box3 = box1;
		box3 = new Box(); // 6
		
		// Mandatory(Manually classes) : Initial Object => Via 'new' keyword : 
		// Available class (JAVA class): Initial Object with 2 ways
		// Integer, String, Double
		Integer a1 = 10;
	}
}

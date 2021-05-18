package inheritance.demo;

public class App {
	public static void main(String[] args) {
		
		// Only override method, No-override attribute
		// Inherit method, attribute
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	}
}

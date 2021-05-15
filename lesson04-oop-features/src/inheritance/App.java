package inheritance;

public class App {
	public static void main(String[] args) {
		// parent #number(11) #text(parent) #log(Log in Parent class)
		// child #number(12) #text(child) #log(Log in child class)
		// Override method, no-Override attribute
		// Inherit method , attribute
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	}
}

package inheritance;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class!)
		// Child #number(99) #text(child) #log(Log in Child class!)
		// Override method, No-Override attribute
		// Inherit method, attribute

		ParentIrt p = new ChildIrt();
		System.out.println(p.number); 	// 11
		System.out.println(p.text);   	// parent
		p.log(); 						// Log in Child class!

		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	}
}

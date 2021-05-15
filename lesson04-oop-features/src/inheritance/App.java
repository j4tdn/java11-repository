package inheritance;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class);
        // Parent #number(11) #text(parent) #log(Log in Parent class);
		// Override method, No-Override attribute
		// Inherit method, attribute
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		//ChildIrt c = new ChildIrt();
		//System.out.println("is Happy: " + c.isHappy);
	}
}

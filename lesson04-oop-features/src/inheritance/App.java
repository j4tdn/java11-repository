package inheritance;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log i Parent Class)
		// Child #number(12) #text(child) #log(Log in Child class) extends Parent
		// Override method, No-Override attribute

		ParentIrt p = new ChildIrt(); 
		System.out.println(p.number); // 11
		System.out.println(p.text); // parent
		p.log(); 		// Log in Child class
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: "+c.isHappy);
	}
}

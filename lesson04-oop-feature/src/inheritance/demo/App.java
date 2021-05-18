package inheritance.demo;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class)
		// Child  #number(99) #text(child) #log(Log in Child class)
		// Override method, No-Override attribute
		
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	}

}

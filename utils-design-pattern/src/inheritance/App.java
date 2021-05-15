package inheritance;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class)
		// Child #number(99) #text(child) #log(log in Children class)
		// Override method, No-Override attribute

		ParentIrt irt = new ChildIrt();
		System.out.println(irt.number); // 11
		System.out.println(irt.text); // parent
		irt.log(); // Log in Children class

		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	}

}

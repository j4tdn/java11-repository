package inheritance;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class)
		// Child #number(99) #text(child) #log(log in Children class)
		// Override method, No-Override attribute

		ParentIrt p = new ChildIrt(); // 11
		System.out.println(p.number); // parent
		System.out.println(p.text);  
	}

}

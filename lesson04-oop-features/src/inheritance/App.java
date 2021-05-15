package inheritance;

public class App {
	public static void main(String[] args) {
		//Parent #number(11) #text(parent) #log(Log in Parent class)
		//Child #number(99) #text(child) #log(Log in Child class) extends Parent class
		// Inherit method and attribute but Override method only, NO override attribute
		
		ParentIrt p = new ChildIrt();
		System.out.println(p.number); // NO override attribute => parent
		System.out.println(p.text); // NO override attribute => parent
		p.log(); // overriding method => child
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	}
}

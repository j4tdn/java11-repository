package inheritance.demo;

import inheritance.superclass.AbstractEmail;
import inheritance.superclass.StandardEmail;
import inheritance.superclass.SubTransformer;
import inheritance.superclass.Transformer;

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
		
		Transformer t1 = new SubTransformer();
		t1.send("centent");
		
		AbstractEmail a1 = new StandardEmail();
		// a1.login();
	}
}

package inheritance.demo;

import inheritance.superclass.AbstractEmail;
import inheritance.superclass.StandardEmail;
import inheritance.superclass.SubTransformer;
import inheritance.superclass.Transformer;

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

		// ChildIrt c = new ChildIrt();
		// System.out.println("is Happy: " + c.isHappy);

		// inheritance.superclass
		Transformer t1 = new SubTransformer();
		t1.send("content");

		AbstractEmail a1 = new StandardEmail();
		// a1.login();
	}
}

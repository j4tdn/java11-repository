package inheritance.demo;

import inheritance.superclass.AbstractEmail;
import inheritance.superclass.StandardEmail;
import inheritance.superclass.SubTransformer;
import inheritance.superclass.Transformer;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class)
		// Child #number(11) #text(child) #log(Log in child class)
		// override method, no-override attribute
		// Inherit method, attribute
		
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		ParentIrt c = new ChildIrt();
		System.out.println(c.ishappy);
		
		//inheritance.superclass
		Transformer t1 = new SubTransformer();
		t1.send("content");
		
		AbstractEmail a1 = new StandardEmail();
		//a1.login
	}
}

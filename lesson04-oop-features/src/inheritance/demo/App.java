package inheritance.demo;

import inheritance.supperclass.AbstractEmail;
import inheritance.supperclass.StandardEmail;
import inheritance.supperclass.SubTrans;
import inheritance.supperclass.Transformer;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class)
		// Child #number(99) #text(child) #log(Log in Child class)
		// Override method, No-Override attribute
		// Inherit method, attribute

		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();

		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy());
		
		//inheritance.superclass
		
		Transformer t1 = new SubTrans();
		t1.send("content");
		
		AbstractEmail a1 = new StandardEmail();
		// a1.login();
	}
}

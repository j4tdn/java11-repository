package inheritance.demo;

import inheritance.supperclass.AbstractEmail;
import inheritance.supperclass.StandardEmail;
import inheritance.supperclass.SubTransformer;
import inheritance.supperclass.Transformer;

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
		
		// inheritance.supperclass
		
		Transformer t1 = new SubTransformer();
		t1.send("content");
		
		AbstractEmail a1 = new StandardEmail();
	}

}

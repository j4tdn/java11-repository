package inheritance.demo;

import inheritance.superclass.AbstractEmail;
import inheritance.superclass.StandardEmail;
import inheritance.superclass.SubTransformer;
import inheritance.superclass.Transformer;

public class App {
	public static void main(String[] args) {
		// Parent #number(11) #text(parent) #log(Log in Parent class)
		// Child #number(99) #text(child) #log(log in Children class)
		// Override method, No-Override attribute

		ParentIrt p = new ChildIrt(); 
		System.out.println(p.number); // 11
		System.out.println(p.text);   // parent
		p.log();                      // Log in Child class     
		
		ChildIrt  c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
	    
		// inheritance.superclass
		Transformer t1 = new SubTransformer();
		t1.send("content");
		
		AbstractEmail a1 = new StandardEmail();
		// a1.login();
	}

}

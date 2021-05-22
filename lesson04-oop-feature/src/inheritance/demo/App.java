package inheritance.demo;

import inheritance.superclass.AbstractEmail;
import inheritance.superclass.StandardEmail;
import inheritance.superclass.SubTrans;
import inheritance.superclass.Transformer;

public class App {
	public static void main(String[] args) {
		
		// Only override method, No-override attribute
		// Inherit method, attribute
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
		
		// inheritance.superclass
		Transformer t1 = new SubTrans();
		t1.send("content");
		
		AbstractEmail e1 = new StandardEmail();
//		e1.login();
	}
}

package inheritance;

import inheritance.superclass.AbstractEmail;
import inheritance.superclass.StandardEmail;
import inheritance.superclass.SubTransformer;
import inheritance.superclass.Transformer;

public class App {
	public static void main(String[] args) {
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		
		ChildIrt c = new ChildIrt();
		System.out.println("isHappy: " + c.isHappy);
		
		//inheritance.superclass
		Transformer t1 = new SubTransformer();
		t1.send("content");
		
		AbstractEmail a1 = new StandardEmail();
		//a1.login();
	}
}

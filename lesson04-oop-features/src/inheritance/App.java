package inheritance;

import inheritance.superclass.SubTransformer;
import inheritance.superclass.Transformer;

public class App {
	public static void main(String[] args) {
		
		ParentIrt p = new ChildIrt();
		System.out.println(p.number);
		System.out.println(p.text);
		p.log();
		

		
		Transformer t1 = new SubTransformer();
		t1.send("content");
		
	}

}

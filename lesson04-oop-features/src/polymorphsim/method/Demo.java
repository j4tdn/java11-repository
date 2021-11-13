package polymorphsim.method;

import static polymorphsim.method.MathUtils.*;

import encapsulation.inside.Developer;
public class Demo {
	public static void main(String[] args) {
		//overloading
		MathUtils.sum(1, 2);
		MathUtils.sum(1.2f, 2.2f);
		sum(1,2,3);
		//override : parent, child
		Developer dev = new Developer();
		
	}
}
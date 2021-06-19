package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
 // String: Immutable Mutable 
 // Immutable: Literal,Object
	
	String o1 = "welcome";
	JvmUtils.hash("o1: " , o1);
	System.out.println("o1: " + o1);
	o1 = "weareone";
	JvmUtils.hash("o1: ", o1);
	System.out.println(": " + o1);
}
	
}

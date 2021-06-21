package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		//String: immutable and mutable
		// immutable: Literal, Objects
		
		String o1 =  new String("welcome");
		JvmUtils.hash("o1: ", o1);
		System.out.println("o1: " + o1);
		
		o1 = new String("we r one"); 
		JvmUtils.hash("o1: ", o1);
		System.out.println("l1: " + o1);
	}
}

package mutable;

import hashutils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		//Immutable: String(Literal, Object)
		
		String i = "Box";
		JvmUtils.hash("i1", i);
		i = i.concat("Layout");
		JvmUtils.hash("i2", i);
		
		System.out.println("Value i: " + i);
		
		//Mutable: StringBuilder, StringBuffer
		StringBuilder m = new StringBuilder("Pattern");// normal - heap
	    JvmUtils.hash("m1", m);
	    m = m.append(" Pattern")
	    	.append("Java")
	    	.reverse();
	    JvmUtils.hash("m2", m);
	    
	    System.out.println("Value m: " + m);
	}

}

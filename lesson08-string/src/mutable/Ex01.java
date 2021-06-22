package mutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// Immutable: String() 
		String i = "Box";  // constant pool - heap
		JvmUtils.hash("i", i);
		
		i = i.concat(" Layout");
		JvmUtils.hash("i2", i);
		System.out.println("Value i: " + i);
		
		// Mutable: StringBuilder, StringBuffer
		StringBuilder m = new StringBuilder("Pattern"); // normal - heap 
		JvmUtils.hash("m1", m);
		m = m.append(" Pattern")
			 .append(" JAVA")
			 .reverse();
		JvmUtils.hash("m2", m);
		System.out.println("Value m: " + m);
		
	}
}

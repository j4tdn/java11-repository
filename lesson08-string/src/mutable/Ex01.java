package mutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// Immutable: String(Literal, Object)
		String i = "Box";	// constant pool
		JvmUtils.hash("i", i);
		i = i.concat("Layout");
		JvmUtils.hash("i2", i);
		System.out.println("Value i: " + i);
		
		// Mutable: StringBuilder, StringBuffer
		StringBuilder m = new StringBuilder("Box") ;	// normal heap
		JvmUtils.hash("m", m);
		m.append("Layout").append("JAVA").reverse();
		JvmUtils.hash("m", m);
		System.out.println("Value m: " + m);
	}
}

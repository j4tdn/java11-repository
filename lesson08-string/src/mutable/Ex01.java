package mutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// Immutable: String(Literal, Object)
		String i = "Box"; // constant pool
		JvmUtils.hash("i1", i);
		
		i = i.concat("Layout");
		JvmUtils.hash("i2", i);
		
		System.out.println("Value i : " + i);

		// Mutable: StringBuilder, StringBuffer
		StringBuffer m = new StringBuffer("Singleton"); // normal - heap
		JvmUtils.hash("m1", m);
		
		m = m.append(" Pattern")
				.append("JAVA")
				.reverse();
		JvmUtils.hash("m2", m);
		
		System.out.println("Value m : " + m);
	}
}

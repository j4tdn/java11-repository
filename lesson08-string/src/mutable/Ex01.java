package mutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		//immutable: String(literal, object)
		String i = "Box"; //constant pool
		JvmUtils.hash("i1", i);
		
		i = i.concat("layout");
		JvmUtils.hash("i2", i);
		System.out.println("Value i: " + i);
		
		//mutable: StringBuilder, StringBuffer
		StringBuffer m = new StringBuffer("Singleton"); //normal-heap
		JvmUtils.hash("m1", m);
		m = m.append("pattern")
			 .append("JAVA")
			 .reverse();
		JvmUtils.hash("m2", m);
		System.out.println("Value m: " + m);
	}
}

package mutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// Immutable : String Literal Object
		String i = "Box"; // constant pool
		JvmUtils.hash("i1 : ", i);
		i = i.concat(" Layout");
		JvmUtils.hash("i2 : ", i);
		// Mutable : String Buffer Builder
		StringBuilder m = new StringBuilder("Singleton"); // normal - heap
		JvmUtils.hash("m1 : ", m);
		m = m.append(" Pattern");
		JvmUtils.hash("m1 : ", m);
	}
}

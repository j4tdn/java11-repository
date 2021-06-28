package mutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		String i = "Box";
		JvmUtils.hash("i", i);
		
		i.concat("Layout");
		JvmUtils.hash("m2", i);

		
		StringBuilder m = new StringBuilder("Singleton");
		JvmUtils.hash("m", m);
		m = m.append("Pattern");
		
		JvmUtils.hash("m2", m);
		
		
	}

}

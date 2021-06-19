package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// String: immutable, Mutable
		// Immutable: literal, object

		String l1 = "welcome";
		System.out.println("l1: " + l1 );
		JvmUtils.hash("l1", l1);
		
		l1 = "wareone";
		System.out.println("l1: " + l1 );
		JvmUtils.hash("l1", l1);
	}
	
	
}

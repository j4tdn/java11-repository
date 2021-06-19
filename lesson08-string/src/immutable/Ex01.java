package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// String: Immutable Mutable
		// Immutable: Literal, Object
		
		String o1 = new String("Welcome");
		JvmUtils.hash("o1", o1);
		System.out.println("o1: " + o1);
		
		o1 = new String("weareone");
		hash(o1);
		System.out.println("o1: " + o1);
	}
	
	private static void hash(String s) {
		System.out.println(System.identityHashCode(s));
	}
}

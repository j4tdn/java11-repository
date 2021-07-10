package immutable;

import utils.JvmUtils;

public class Ex01 {
	// Immutable
	public static void main(String[] args) {
		// String: Immutable Mutable
		// Immutable: Literal, Object
		
		String l1 = new String("welcome");
		JvmUtils.hash("l1 hash: ", l1);
		System.out.println("l1: " + l1);
		
		l1 = new String("weareone");
		JvmUtils.hash("l1 hash: ", l1);
		System.out.println("l1: " + l1);
	
		// daemon thread: garbage collection
	}
}

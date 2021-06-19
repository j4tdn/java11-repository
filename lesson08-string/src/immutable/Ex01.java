package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// String: Immutable Mutable
		// Immutable: Literal, Object

		// Literal
		String l1 = "Welcome";
		String o1 = new String("welcome");
		JvmUtils.hash("l1: ", l1);
		JvmUtils.hash("o1: ", o1);

		System.out.println("l1: " + l1);

		System.out.println("============");

		l1 = "weareone";
		o1 = "weareone";
		JvmUtils.hash("l1: ", l1);
		JvmUtils.hash("o1: ", o1);

		System.out.println("l1: " + l1);
	}

}

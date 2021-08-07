package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// String: Immutable Mutable
		// Immutable: Literal, Object

		String l1 = "welcome";
		JvmUtils.hash("l1", l1);
		System.out.println("l1" + l1);
		l1 = "weareone";
		JvmUtils.hash("l1", l1);
		System.out.println("l1" + l1);
	}

}

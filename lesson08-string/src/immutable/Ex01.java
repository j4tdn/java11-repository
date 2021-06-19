package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// String : Immutable & Mutable
		// Immutable : Literal , Object

		String o1 = new String("welcome");
		JvmUtils.hash("o1 : ", o1);
		
		
		o1 = new String("weareone");
		JvmUtils.hash("o1 : ", o1);
	}
	
	
}

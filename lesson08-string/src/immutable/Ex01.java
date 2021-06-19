package immutable;

import utils.JvmUtils;

public class Ex01 {
	public static void main(String[] args) {
		// String: Immutable Mutable
		// Immutable: Literal, Object
		
		String o1 = new String("hoadeptrai");
		JvmUtils.hash("o1: ", o1);
		System.out.println("o1: " + o1);
		
		o1 = new String("hoaratdep");
		JvmUtils.hash("o1: ", o1);;
		System.out.println("o1: " + o1);
	}
	
}

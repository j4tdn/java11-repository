package immutable;

import javax.print.attribute.HashAttributeSet;

public class Ex01 {
	public static void main(String[] args) {
		// String: Immutable Mutable
		//Immutable: Literal, object bat bien khi chua gia tri String
		
		
		String l1 = new String ("welcome");
		hash(l1);
		System.out.println("l1: " +l1);
		
		l1 ="weareone";
		hash(l1);
		System.out.println("l1: " +l1);
	}
	public static void hash(String s) {
		System.out.println(System.identityHashCode(s));
	}

}

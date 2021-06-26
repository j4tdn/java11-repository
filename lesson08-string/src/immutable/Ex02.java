package immutable;

import utils.JvmUtils;

public class Ex02 {
	public static void main(String[] args) {
		// Difference between String Literal and Object

		String s1 = "literal";
		String s2 = "literal";
		String s3 = "lite" + "ral";
		JvmUtils.hash("s1", s1);
		JvmUtils.hash("s2", s2);
		JvmUtils.hash("s3", s3);

		System.out.println("===========");

		// unused
		String o1 = new String("Object");
		String o2 = new String("literal");
		String o3 = new String("literal");
		JvmUtils.hash("o1", o1);
		JvmUtils.hash("o2", o2);
		JvmUtils.hash("o3", o3);

		// So sánh:
		// ==(stack-variable)
		// Object#equals(default-stack-variable, being override-value)
		// Comparable#comparaTo = > <
		System.out.println("s1==s2 " + (s1 == s2)); // T
		System.out.println("s1==s3 " + (s1 == s3)); // T
		System.out.println("s1==o1 " + (s1 == o1)); // F
		System.out.println("o1==o2 " + (o1 == o2)); // F
		System.out.println("o1==o3 " + (o1 == o3)); // F
		System.out.println("o2==o3 " + (o2 == o3)); // F

		System.out.println("s1 eq s2 " + (s1.equals(s2)));
		System.out.println("s1 eq s3 " + (s1.equals(s3)));
		System.out.println("s1 eq o1 " + (s1.equals(o1)));
		System.out.println("o1 eq o2 " + (o1.equals(o2)));
		System.out.println("o1 eq o3 " + (o1.equals(o3)));
		System.out.println("o2 eq o3 " + (o2.equals(o3)));

		System.out.println("s1 cp s2: " + (s1.compareTo(s2)));
		System.out.println("s1 cp o1: " + (s1.compareTo(o1)));
	}
}

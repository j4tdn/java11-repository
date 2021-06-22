package immutable;

import hashutils.JvmUtils;

public interface Ex02 {
	public static void main(String[] args) {
		// Diferrence between String Literal and Object
		
		String s1 = "literal";
		String s2 = "literal";
		String s3 = "lite" + "ral";
		JvmUtils.hash("s1", s1);
		JvmUtils.hash("s2", s2);
		JvmUtils.hash("s3", s3);
		System.out.println("=====");
		
		String o1 = new String("object");
		String o2 = new String("literal");
		String o3 = new String("literal");
		JvmUtils.hash("o1", o1);
		JvmUtils.hash("o2", o2);
		JvmUtils.hash("o3", o3);
		
		// Compare: 
		// ==(stack-variable) 
		// Objects#equals(default-stack-variable, being override)
		// Comparable # compare = > < 
		System.out.println("s1==s2: " + (s1==s2)); // True
		System.out.println("s1==s3: " + (s1==s3)); // True
		System.out.println("s1==o1: " + (s1==o1)); // False
		System.out.println("o1==o2: " + (o1==o2)); // False
		System.out.println("o1==o3: " + (o1==o3)); // False
		
		System.out.println("s1 eq s2: " + s1.equals(s2)); // True
		System.out.println("s1 eq s3: " + s1.equals(s3)); // True
		System.out.println("o1 eq o1: " + s1.equals(o1)); // False
		System.out.println("o1 eq o2: " + o1.equals(o2)); // False
		System.out.println("o2 eq o3: " + o1.equals(o3)); // False
		System.out.println("o2 eq o3: " + o2.equals(o3)); // False
		
		System.out.println("s1 cp s2: " + (s1.compareTo(s2)));
		System.out.println("s1 cp o1: " + (s1.compareTo(o1)));
	}
}
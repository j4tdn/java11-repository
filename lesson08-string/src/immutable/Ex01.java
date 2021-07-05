package immutable;

public class Ex01 {
	public static void main(String[] args) {
		// literal versus object
		// literal: heap(constant-pool)
		String l1 = "hello";
		String l2 = "welcome";
		String l3 = "welcome";
		
		hash("l1", l1);
		hash("l2", l2);
		hash("l3", l3);
		
		
		// Immutable: Bat bien = ko the thay doi gia tri
		// Reality: Immutable for string value in heap
		System.out.println("=========Immutable==========");
		
		String i1 = "one";
		hash("i1", i1);
		i1 = "two";
		hash("i1", i1);
		System.out.println("i1: " + i1);
		
		System.out.println("===================");
		//object: heap(normal)
		String o1 = new String("hello");
		String o2 = new String("welcome");
		String o3 = new String("welcome");
		
		hash("o1", o1);
		hash("o2", o2);
		hash("o3", o3);
	}
	
	private static void hash(String text, String input) {
		System.out.println(text + ": " + System.identityHashCode(input));
	}
}

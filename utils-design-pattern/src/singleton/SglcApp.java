package singleton;

public class SglcApp {
	public static void main(String[] args) {
		Sglc s1 = Sglc.getInstance();
		Sglc s2 = Sglc.getInstance();
		
		s1.setValue("HELLO - 2021");
		
		System.out.println("s1: "+ System.identityHashCode(s1));
		System.out.println("s2: "+ System.identityHashCode(s2));
		
		// Can we create a class with private constructor
		// 1. Enumeraion
		// 2. Utility class
		// 3. Singleton pattern
	}
}

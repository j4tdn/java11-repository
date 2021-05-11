package singleton;

public class SglcApp {
	public static void main(String[] args) {
		Sglc c1 = Sglc.getInstance();
		Sglc c2 = Sglc.getInstance();
		
		c1.setValue("HELLO - 2021");
		System.out.println(c1.getValue());
		System.out.println(c2.getValue());
		
//		System.out.println("s1: " + System.identityHashCode(s1));
//		System.out.println("s2: " + System.identityHashCode(s2));
		
		// can we create a
	}

}

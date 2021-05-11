package singleton;

public class SglcApp {
	public static void main(String[] args) {
		Sglc s1 = Sglc.getInstance();
		Sglc s2 = Sglc.getInstance();
		
		s1.setValue("hello");
		
		System.out.println(s1.getValue());
		System.out.println(s1.getValue());
		
		System.out.println("s1: " + System.identityHashCode(s1));
		System.out.println("s1: " + System.identityHashCode(s2));
	}

}

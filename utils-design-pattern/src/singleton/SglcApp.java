package singleton;

public class SglcApp {
	public static void main(String[] args) {
		Sglc s1 = Sglc.getInstance();
		Sglc s2 = Sglc.getInstance();
		
		s1.setValue("Hello - 2021");
		
		System.out.println(s1.getValue());
		System.out.println(s2.getValue());
		
		
		System.out.println("s1: " + System.identityHashCode(s1));
		System.out.println("s2: " + System.identityHashCode(s2));
		
		// can we create a class with private constructor ? yes nhung chi cho mojt doi tuojng su dung thoi
		//1.Enumeration
		//2.Utility class
		//3.Singleton pattern
	}

}

package singleton;

public class SglcApp {
	public static void main(String[] args) {
		Sglc s1 = Sglc.getIntance();
		Sglc s2 = Sglc.getIntance();
		
		s1.setValue("Hello - 2021");
		
		System.out.println("s1 :" + s1.getValue());
		System.out.println("s2 :" + s2.getValue());
	}
}

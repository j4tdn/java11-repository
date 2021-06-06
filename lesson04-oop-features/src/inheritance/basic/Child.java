package inheritance.basic;

public class Child extends Parent{
	int number = 20;
	
	@Override
	void text() {
		System.out.println("Child >> texting.....");
	}
	
	@Override
	void log(String message) {
		System.out.println("Child >> "+message);
	}
	
	
}

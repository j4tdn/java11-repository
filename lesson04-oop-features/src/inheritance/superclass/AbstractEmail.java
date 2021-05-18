package inheritance.superclass;

public abstract class AbstractEmail {

	abstract void login();
	
	void loginWith2Steps() {
		System.out.println("AbstractEmail >> loginWith2Steps");
	}
}

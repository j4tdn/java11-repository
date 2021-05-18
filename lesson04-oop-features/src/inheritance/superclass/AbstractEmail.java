package inheritance.superclass;

public abstract class AbstractEmail {
	abstract void login();
	void loginWith2Steps() {
		System.out.println("AbstractEmail >> loginwith2Steps");
	}
}

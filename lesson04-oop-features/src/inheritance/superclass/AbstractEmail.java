package inheritance.superclass;

public abstract class AbstractEmail {
	// no body
	abstract void login();

	void longinWith2Steps() {
		System.out.println("AbstractEmail >> loginWith2Steps");
	}
}

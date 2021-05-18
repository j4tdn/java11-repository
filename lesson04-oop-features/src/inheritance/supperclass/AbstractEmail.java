package inheritance.supperclass;

public abstract class AbstractEmail {
	// no body
	abstract void login();

	void loginWith2Steps() {
		System.out.println("AbstractEmail >> loginWith2Steps ...");
	}
}

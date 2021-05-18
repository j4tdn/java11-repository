package inheritance.superclass;

public abstract class AbstractEmail {
	//nobody
	abstract void login();
	
	
	void loginWith2Steps() {
		//body
		System.out.println("AbstractEmail >> loginWith2Steps");
	}
}

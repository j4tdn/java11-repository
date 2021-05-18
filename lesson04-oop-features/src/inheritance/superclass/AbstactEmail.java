package inheritance.superclass;

public abstract class AbstactEmail {
	abstract void login() ;
		//  no body
	void loginWith2Steps() {
		System.out.println("AbstactEmail >> loginWith2Steps ! ");
	}
}

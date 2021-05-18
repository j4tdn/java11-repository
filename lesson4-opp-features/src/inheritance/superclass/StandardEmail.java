package inheritance.superclass;

public class StandardEmail extends AbstractEmail {

	@Override
	void login() {
		System.out.println("Standard Email >> login....");
	}

}

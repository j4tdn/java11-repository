package inheritance.ssuper;

public class BusinessEmail extends AbstractEmail{

	@Override
	void login() {
		System.out.println("BusinessEmail >> login ...");
	}
	
	@Override
	void loginWith2Steps() {
		System.out.println("BusinessEmail >> login ...");
	}

}

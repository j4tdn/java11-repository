package inheritance.ssuper;

public class BusinessEmail extends AbstractEmail {

	@Override
	void login() {
		System.out.println("BusinessEmail >> login ...");
	}
	
	@Override
	void loginwith2step() {
		System.out.println("BusinessEmail >> loginwith2step ...");
	}

}

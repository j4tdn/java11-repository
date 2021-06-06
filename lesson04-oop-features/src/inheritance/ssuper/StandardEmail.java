package inheritance.ssuper;

public class StandardEmail extends AbstractEmail{

	@Override
	void login() {
		System.out.println("StandardEmail >> login ...");
	}
	
}	

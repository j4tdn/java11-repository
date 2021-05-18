package inheritance.superclass;

public class BusinessEmail extends AbstractEmail implements Transformer{

	@Override
	void login() {
		System.out.println("BussinessEmail >> login...");
	}

	@Override
	public void send(String message) {
		System.out.println("Encrypted " + message);
	}
	
}

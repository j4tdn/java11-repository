package inheritance.superclass;

public class BusinessEmail extends AbtractEmail implements Transformer{

	@Override
	void login() {
		System.out.println("BusinessEmail >> login ... ");

	}

	@Override
	public void send(String message) {
		System.out.println("Encrypted " + message);
		
	}

}

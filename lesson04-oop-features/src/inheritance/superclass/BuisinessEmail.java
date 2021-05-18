package inheritance.superclass;

public class BuisinessEmail extends AbstractEmail implements Transformer {

	@Override
	
	public void send(String message) {
		System.out.println("Encrypted " + message);
	}

	@Override
	void login() {
		System.out.println("BuisinessEmail >> login ...");

	}

}

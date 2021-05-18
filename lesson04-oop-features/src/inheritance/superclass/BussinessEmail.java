package inheritance.superclass;

public class BussinessEmail extends AbstractEmail implements Transformer {

	@Override
	void login() {
		System.out.println("Bussiness >> login ...");

	}

	@Override
	public void send(String message) {
		System.out.println("Encrypted "+message);
		
	}

}

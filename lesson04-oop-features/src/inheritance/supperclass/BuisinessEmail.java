package inheritance.supperclass;

public class BuisinessEmail extends AbstractEmail implements Transformer {

	@Override
	void login() {
		System.out.println("BuisinessEmail >> login ...");
	}

	@Override
	public void send(String message) {
		System.out.println("Encrypted " + message);
	}

}

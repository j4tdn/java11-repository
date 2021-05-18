package inheritance.superclass;

public class BusinessEmail extends AbstactEmail implements Tranformer {

	@Override
	void login() {
		System.out.println("BusinessEmail >> Login ! ");
	}

	@Override
	public void send(String message) {
		System.out.println("Encrypted " + message);
		
	}

}

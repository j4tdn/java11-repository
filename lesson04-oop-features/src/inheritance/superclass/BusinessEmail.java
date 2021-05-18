package inheritance.superclass;

public class BusinessEmail extends AbstractEmail implements Transformer {

	@Override
	void login() {
		System.out.println("BusinessEmail >> Login ...");

	}

	@Override
	public void send(String messsage) {
		System.out.println("Encryted" + messsage);
		
	}

}

package inheritance.superclass;

public class SubTransformer implements Transformer {

	@Override
	public void send(String message) {
		System.out.println("t2 send: " + message);		
	}
	
}

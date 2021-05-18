package inheritance.superclass;

public class SubTransformer implements Transformer {

	@Override
	public void send(String message) {
		System.out.println("T2 send " + message);
	}
   
}

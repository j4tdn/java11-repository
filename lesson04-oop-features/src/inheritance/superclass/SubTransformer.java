package inheritance.superclass;

public class SubTransformer implements Transformer {
	@Override
	public void send(String messsage) {
		System.out.println("T2 send " + messsage);
	}
}

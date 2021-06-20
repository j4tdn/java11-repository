package inheritance.superclass;

public class SubTrans implements Transformer{

	@Override
	public void send(String message) {
		System.out.println("T2 send " + message);
		
	}
	
}
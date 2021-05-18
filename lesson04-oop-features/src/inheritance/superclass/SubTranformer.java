package inheritance.superclass;

public class SubTranformer  implements Tranformer{
	@Override
	public void send(String message) {
		System.out.println("T2 : " + message);
		
	}
}

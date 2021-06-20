package inheritance.superclass;

public class App {
	public static void main(String[] args) {
		Transformer t1 = new BusinessEmail();
		t1.send("content");
		System.out.println("Runtime: " + t1.getClass().getSimpleName());

		//anonymous class
//		Transformer t2 = new Transformer() {
//			
//			@Override
//			public void send(String message) {
//				System.out.println("T2 send " + message);
//				
//			}
//		};
		
		Transformer t2 = new SubTrans();
		t2.send("secret info");
	}
}
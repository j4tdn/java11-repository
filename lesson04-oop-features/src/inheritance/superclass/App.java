package inheritance.superclass;

public class App {
	public static void main(String[] args) {
		Transformer t1 = new BusinessEmail();
		t1.send("content");
		System.out.println("runtime: "+ t1.getClass().getSimpleName());
		
		
		BusinessEmail b1 = new BusinessEmail();
		b1.send("business content");
		System.out.println("runtime: "+ b1.getClass().getSimpleName());
		
		// anonymous class: lop cap nhat
//		Transformer t2 = new Transformer() {
//			
//			@Override
//			public void send(String message) {
//				System.out.println("t2 send "+ message);
//				
//			}
//		};
		Transformer t2 = new SubTransformer();
		t2.send("secret info");
		System.out.println("runtime: "+ t2.getClass().getSimpleName());
	}
}

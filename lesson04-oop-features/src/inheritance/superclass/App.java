package inheritance.superclass;

public class App {
	public static void main(String[] args) {
		Transformer t1 = new BusinessEmail();
		t1.send("content");
		System.out.println("Runtime t1: " + t1.getClass().getSimpleName());
		System.out.println("==========================");
		
		BusinessEmail b1 = new BusinessEmail();
		b1.send("busines content");
		System.out.println("Business email: " + b1.getClass().getSimpleName());
		System.out.println("==========================");
		
//		anonymous class
//		Transformer t2 = new Transformer() {
//			
//			@Override
//			public void send(String message) {
//				System.out.println("T2" + message);
//			}
//		};
		
		Transformer t2 = new SubTransformer();
		t2.send("secret info");
		System.out.println("Business email: " + t2.getClass().getSimpleName());
	}
}

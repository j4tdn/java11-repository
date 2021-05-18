package inheritance.superclass;

public class App {
	public static void main(String[] args) {
		Transformer t1 = new BusinessEmail();
		t1.send("content");
		System.out.println("Runtime: " + t1.getClass().getSimpleName());

		System.out.println("===================");

		BusinessEmail b1 = new BusinessEmail();
		b1.send("business content");
		System.out.println("Runtime: " + t1.getClass().getSimpleName());

//		Transformer t2 = new Transformer() {
//
//			// anonymous class: lớp ẩn danh
//			@Override
//			public void send(String message) {
//				System.out.println("T2 send " + message);
//			}
//		};
		
		Transformer t2 = new SubTransformer();
		t2.send("secret info");
		System.out.println("Runtime t2: " + t2.getClass().getSimpleName());
	}

}

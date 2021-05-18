package inheritance.supperclass;

public class App {
	public static void main(String[] args) {
		Transformer t1 = new BuisinessEmail();
		t1.send("content");
		System.out.println("Runtime: " + t1.getClass().getSimpleName());
		
		System.out.println("============================");
		
		BuisinessEmail b1 = new BuisinessEmail();
		b1.send("buisiness content");
		System.out.println("Runtime b1: " + b1.getClass().getSimpleName());
		
		System.out.println("============================");
		
		// anonymous class
//		Transformer t2 = new Transformer() {
//			
//			@Override
//			public void send(String message) {
//				System.out.println("T2 send " + message);
//			}
//		};
		Transformer t2 = new SubTrans();
		t2.send("secret info");
		System.out.println("Runtime t2 " + t2.getClass().getSimpleName());
	}
}

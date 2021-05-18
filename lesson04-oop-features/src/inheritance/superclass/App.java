package inheritance.superclass;

public class App {
	public static void main(String[] args) {
		Tranformer t1 = new BusinessEmail();
		t1.send("content");
			
		System.out.println("Runtime : " + t1.getClass().getSimpleName());
		System.out.println("==================================");
		
		BusinessEmail b1 = new BusinessEmail();
		b1.send("bussiness content");
		
		
		// anonymous class : lop an danh 
//		Tranformer t2 = new Tranformer() {
//			
//			@Override
//			public void send(String message) {
//				System.out.println("T2 send : " + message);
//			}
//		};
		
		Tranformer t2 = new SubTranformer();
		t2.send("serect info");
		System.out.println("Runtime : " + t2.getClass().getSimpleName());
		
	}
}

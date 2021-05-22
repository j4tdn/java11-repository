package bai5;

public class app {
	public static void main(String[] args) {
		Textbook b1 = new Textbook();
		b1.setId("SGK111");
		b1.setPrice(200);
		b1.setPublisher("Nhi Đồng");
		b1.setStatus("Sách cũ");
		Textbook b2 = new Textbook();
		b1.setId("SGK112");
		b1.setPrice(100);
		b1.setPublisher("Giáo Dục");
		b1.setStatus("Sách cũ");
		Textbook b3 = new Textbook();
		b1.setId("SGK113");
		b1.setPrice(150);
		b1.setPublisher("Nhi Đồng");
		b1.setStatus("Sách cũ");
		
		ReferenceBook r1 = new ReferenceBook();
		r1.setId("STK111");
		r1.setPrice(120);
		r1.setPublisher("Nhi Đồng");
		r1.setTax(0.5f);
		ReferenceBook r2 = new ReferenceBook();
		r1.setId("STK112");
		r1.setPrice(120);
		r1.setPublisher("Giáo dục");
		r1.setTax(0.5f);
	}
}

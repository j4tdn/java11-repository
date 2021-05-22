package bai05;

public class SGK extends Book {
	private String stt;
	
	public SGK() {
		// TODO Auto-generated constructor stub
	}

	public SGK(String idb, String pubcomp, double price, String stt) {
		super(idb, pubcomp, price);
		this.stt = stt;
	}

	@Override
	public String toString() {
		return "SGK [stt=" + stt + "]";
	}
	
}

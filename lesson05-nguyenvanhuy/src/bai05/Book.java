package bai05;

abstract class Book {
	private String idb;
	private String pubcomp;
	private double price;
	
//	abstract public String stt();
//	abstract double tax();

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String idb, String pubcomp, double price) {
		super();
		this.idb = idb;
		this.pubcomp = pubcomp;
		this.price = price;
	}

	public String getIdb() {
		return idb;
	}

	public void setIdb(String idb) {
		this.idb = idb;
	}

	public String getPubcomp() {
		return pubcomp;
	}

	public void setPubcomp(String pubcomp) {
		this.pubcomp = pubcomp;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [idb=" + idb + ", pubcomp=" + pubcomp + ", price=" + price + "]";
	}
	
}

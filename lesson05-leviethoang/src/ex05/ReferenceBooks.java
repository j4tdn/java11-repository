package ex05;

public class ReferenceBooks  {
	private String idRB;
	private double price;
	private String publisher;
	private double vat;
	
	public ReferenceBooks() {
		
	}

	public ReferenceBooks(String idRB, double price, String publisher, double vat) {
		super();
		this.idRB = idRB;
		this.price = price;
		this.publisher = publisher;
		this.vat = vat;
	}

	public String getIdRB() {
		return idRB;
	}

	public void setIdRB(String idRB) {
		this.idRB = idRB;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getVat() {
		return vat;
	}

	public void setVat(double vat) {
		this.vat = vat;
	}

	@Override
	public String toString() {
		return "ReferenceBooks [idRB=" + idRB + ", price=" + price + ", publisher=" + publisher + ", vat=" + vat + "]";
	}

	
	
	
	
	
	
	
	
}

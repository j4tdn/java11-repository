package ex05;

public class TextBook {
	private String idTB;
	private double price;
	private String publisher;
	private boolean status;
	
	public TextBook() {
		
	}

	
	
	
	public TextBook(String idTB, double price, String publisher, boolean status) {
		super();
		this.idTB = idTB;
		this.price = price;
		this.publisher = publisher;
		this.status = status;
	}




	public String getId() {
		return idTB;
	}

	public void setId(String idTB) {
		this.idTB = idTB;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Textbook [idTB =" + idTB + ", price=" + price + ", publisher=" + publisher + ", status=" + status + "]";
	}
	
	
}

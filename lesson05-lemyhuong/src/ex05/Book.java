package ex05;

public class Book {
	private String idBook;
	private double price;
	private String publisher;

	public Book(String idBook, double price, String publisher) {
		super();
		this.idBook = idBook;
		this.price = price;
		this.publisher = publisher;
	}

	public String getIdBook() {
		return idBook;
	}

	public void setIdBook(String idBook) {
		this.idBook = idBook;
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

	@Override
	public String toString() {
		return "idBook=" + idBook + ", price=" + price + ", publisher=" + publisher;
	}

}

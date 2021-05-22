package exercise5;

public class Book {
	private String id;
	private float price;
	private String publisher;
	public Book() {};
	public Book(String id, float price, String publisher) {
		super();
		this.id = id;
		this.price = price;
		this.publisher = publisher;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	
	
}

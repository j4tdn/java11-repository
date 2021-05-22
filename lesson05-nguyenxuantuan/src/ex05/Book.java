package ex05;

public abstract class Book {
	protected BookType type;
	protected String id;
	protected float price;
	protected String publisher;
	
	public Book() {
		
	}
	public Book(BookType type, String id, float price, String publisher) {
		this.type = type;
		this.id = id;
		this.price = price;
		this.publisher = publisher;
	}
	
	public BookType getType() {
		return type;
	}
	public void setType(BookType type) {
		this.type = type;
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
	abstract public float getLastPrice();
	
	@Override
	public String toString() {
		return "Book [type=" + type + ", id=" + id + ", price=" + price + ", publisher=" + publisher + "]";
	}
	
	
	
	
	
	

}

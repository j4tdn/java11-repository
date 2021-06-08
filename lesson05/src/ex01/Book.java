package ex01;

public class Book {
	private String id;
	private double cost;
	private String publisher;
 
	public Book() {
	}

	public String getId() {
		return id;
	}

	public double getCost() {
		return cost;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", cost=" + cost + ", publisher=" + publisher + "]";
	}
	 
	
}
